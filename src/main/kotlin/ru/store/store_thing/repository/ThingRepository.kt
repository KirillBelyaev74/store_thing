package ru.store.store_thing.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import ru.logging.annotation.Log
import ru.store.store_thing.capitalizeWords
import ru.store.store_thing.mapper.ThingBrandCategorySizeMapper
import ru.store.store_thing.mapper.ThingMapper
import ru.store.store_thing.model.BrandCategorySizeDto
import ru.store.store_thing.model.ThingDto

@Repository
@PropertySource("classpath:database/select.sql.properties")
open class ThingRepository : IThingRepository {

    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    @Value("\${insertCategory}")
    private lateinit var insertCategory: String
    @Value("\${insertBrand}")
    private lateinit var insertBrand: String
    @Value("\${insertSize}")
    private lateinit var insertSize: String
    @Value("\${insertThing}")
    private lateinit var insertThing: String

    @Value("\${delete.by.id}")
    private lateinit var deleteById: String

    @Value("\${find.all}")
    private lateinit var selectFindAll: String

    @Value("\${find.all.category}")
    private lateinit var selectFindAllCategory: String
    @Value("\${find.all.brand}")
    private lateinit var selectFindAllBrand: String
    @Value("\${find.all.size}")
    private lateinit var selectFindAllSize: String

    @Value("\${find.all.by.category}")
    private lateinit var selectFindAllByCategory: String
    @Value("\${find.all.by.brand}")
    private lateinit var selectFindByBrand: String
    @Value("\${find.all.by.size}")
    private lateinit var selectFindBySize: String
    @Value("\${find.all.by.middle.price}")
    private lateinit var selectByMiddlePrice: String

    @Log
    override fun save(thing: ThingDto): Int {
        val listCategory = thing.category?.let { findAllThingsByCategory(it) } ?: listOf()
        val listBrand = thing.brand?.let { findAllThingsByBrand(it) } ?: listOf()
        val listSize = thing.size?.let { findAllThingsBySize(it) } ?: listOf()

        fun ifHaveSoCategoryBrandSize(list: List<ThingDto>, insert: String, nameColum: String, valueColum: String) {
            if (list.isEmpty()) {
                jdbcTemplate.update(insert, mapOf(nameColum to valueColum))
            }
        }

        thing.category?.let { ifHaveSoCategoryBrandSize(listCategory, insertCategory , "category", it.capitalizeWords()) }
        thing.brand?.let { ifHaveSoCategoryBrandSize(listBrand, insertBrand, "brand", it.capitalizeWords()) }
        thing.size?.let { ifHaveSoCategoryBrandSize(listSize, insertSize, "size", it.uppercase()) }

        return jdbcTemplate.update(insertThing,
            MapSqlParameterSource()
                .addValue("brand", thing.brand?.capitalizeWords())
                .addValue("category", thing.category?.capitalizeWords())
                .addValue("size", thing.size?.uppercase())
                .addValue("description", thing.description?.capitalizeWords())
                .addValue("price", thing.price))
    }

    @Log
    override fun findAllThings(): List<ThingDto> {
        return jdbcTemplate.query(selectFindAll, ThingMapper())
    }

    @Log
    override fun findAllCategory(): List<BrandCategorySizeDto> {
        return jdbcTemplate.query(selectFindAllCategory, ThingBrandCategorySizeMapper("category"))
    }

    @Log
    override fun findAllBrand(): List<BrandCategorySizeDto> {
        return jdbcTemplate.query(selectFindAllBrand, ThingBrandCategorySizeMapper("brand"))
    }

    @Log
    override fun findAllSize(): List<BrandCategorySizeDto> {
        return jdbcTemplate.query(selectFindAllSize, ThingBrandCategorySizeMapper("size"))
    }

    @Log
    override fun findAllThingsByCategory(category: String): List<ThingDto> {
        return jdbcTemplate.query(selectFindAllByCategory, mapOf("category" to category.capitalizeWords()), ThingMapper())
    }

    @Log
    override fun findAllThingsByBrand(brand: String): List<ThingDto> {
        return jdbcTemplate.query(selectFindByBrand, mapOf("brand" to brand.capitalizeWords()), ThingMapper())
    }

    @Log
    override fun findAllThingsBySize(size: String): List<ThingDto> {
        return jdbcTemplate.query(selectFindBySize, mapOf("size" to size.capitalizeWords()), ThingMapper())
    }

    @Log
    override fun findAllThingsByMiddlePrice(low: Long, high: Long): List<ThingDto> {
        return jdbcTemplate.query(selectByMiddlePrice, mapOf("low" to low, "high" to high), ThingMapper())
    }

    @Log
    override fun deleteById(id: Long): Int {
        return jdbcTemplate.update(deleteById, mapOf("id" to id))
    }
}