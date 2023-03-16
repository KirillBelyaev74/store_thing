package ru.store.store_thing.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.logging.annotation.Log
import ru.store.store_thing.model.BrandCategorySizeDto
import ru.store.store_thing.model.ThingDto
import ru.store.store_thing.repository.IThingRepository

@Service
open class ThingService: IThingService {

    @Autowired
    private lateinit var repository: IThingRepository

    @Log
    override fun save(thing: ThingDto): Int {
        if (thing.category.isNullOrBlank() ||
            thing.brand.isNullOrBlank() ||
            thing.size.isNullOrBlank() ||
            thing.price.toString().isBlank() ||
            thing.description.isNullOrBlank()) {
            throw IllegalArgumentException("Parameters is null or is blank: $thing")
        }
        return repository.save(thing)
    }

    @Log
    override fun findAllThings(): List<ThingDto> {
        return repository.findAllThings()
    }

    @Log
    override fun findAllCategory(): List<BrandCategorySizeDto> {
        return repository.findAllCategory()
    }

    @Log
    override fun findAllBrand(): List<BrandCategorySizeDto> {
        return repository.findAllBrand()
    }

    @Log
    override fun findAllSize(): List<BrandCategorySizeDto> {
        return repository.findAllSize()
    }

    @Log
    override fun findAllThingsByCategory(category: String?): List<ThingDto> {
        if (category.isNullOrBlank()) {
            throw IllegalArgumentException("Parameter category: [$category] is null or blank")
        }
        return repository.findAllThingsByCategory(category)
    }

    @Log
    override fun findAllThingsByBrand(brand: String?): List<ThingDto> {
        if (brand.isNullOrBlank()) {
            throw IllegalArgumentException("Parameter category: [$brand] is null or blank")
        }
        return repository.findAllThingsByBrand(brand)
    }

    @Log
    override fun findAllThingsBySize(size: String?): List<ThingDto> {
        if (size.isNullOrBlank()) {
            throw IllegalArgumentException("Parameter category: [$size] is null or blank")
        }
        return repository.findAllThingsBySize(size)
    }

    @Log
    override fun findAllThingsByMiddlePrice(low: Long, high: Long): List<ThingDto> {
        return repository.findAllThingsByMiddlePrice(low, high)
    }

    @Log
    override fun deleteById(id: Long?): Int {
        if (id == null || id < 1) {
            throw IllegalArgumentException("Not correct this id: $id")
        }
        return repository.deleteById(id)
    }
}