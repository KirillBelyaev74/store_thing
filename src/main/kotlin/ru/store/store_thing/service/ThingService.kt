package ru.store.store_thing.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.store.store_thing.model.BrandCategorySizeDto
import ru.store.store_thing.model.ThingDto
import ru.store.store_thing.repository.IThingRepository

@Service
class ThingService: IThingService {

    @Autowired
    private lateinit var repository: IThingRepository

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

    override fun findAllThings(): List<ThingDto> {
        return repository.findAllThings()
    }

    override fun findAllCategory(): List<BrandCategorySizeDto> {
        return repository.findAllCategory()
    }

    override fun findAllBrand(): List<BrandCategorySizeDto> {
        return repository.findAllBrand()
    }

    override fun findAllSize(): List<BrandCategorySizeDto> {
        return repository.findAllSize()
    }

    override fun findAllThingsByCategory(category: String): List<ThingDto> {
        return repository.findAllThingsByCategory(category)
    }

    override fun findAllThingsByBrand(brand: String): List<ThingDto> {
        return repository.findAllThingsByBrand(brand)
    }

    override fun findAllThingsBySize(size: String): List<ThingDto> {
        return repository.findAllThingsBySize(size)
    }

    override fun findAllThingsByMiddlePrice(low: Long, high: Long): List<ThingDto> {
        return repository.findAllThingsByMiddlePrice(low, high)
    }

    override fun deleteById(id: Long): Int {
        if (id < 1) {
            throw IllegalArgumentException("Not correct this id: $id")
        }
        return repository.deleteById(id)
    }
}