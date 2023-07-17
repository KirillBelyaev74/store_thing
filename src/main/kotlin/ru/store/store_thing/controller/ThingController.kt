package ru.store.store_thing.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.logging.annotation.Log
import ru.store.store_thing.High
import ru.store.store_thing.Low
import ru.store.store_thing.model.BrandCategorySizeDto
import ru.store.store_thing.model.ThingDto
import ru.store.store_thing.service.IThingService

@RestController
open class ThingController(private val service: IThingService) : IThingController {

    @Log
    override fun saveThing(@RequestBody thing: ThingDto): Int {
        return service.save(thing)
    }

    @Log
    override fun getAllThings(): List<ThingDto> {
        return service.findAllThings();
    }

    @Log
    override fun getAllCategory(): List<BrandCategorySizeDto> {
        return service.findAllCategory()
    }

    @Log
    override fun getAllBrand(): List<BrandCategorySizeDto> {
        return service.findAllBrand()
    }

    @Log
    override fun getAllSize(): List<BrandCategorySizeDto> {
        return service.findAllSize()
    }

    @Log
    override fun getAllThingsByCategory(@PathVariable category: String): List<ThingDto> {
        return service.findAllThingsByCategory(category)
    }

    @Log
    override fun getAllThingsByBrand(@PathVariable brand: String): List<ThingDto> {
        return service.findAllThingsByBrand(brand)
    }

    @Log
    override fun getAllThingsBySize(@PathVariable size: String): List<ThingDto> {
        return service.findAllThingsBySize(size)
    }

    @Log
    override fun getAllThingsByMiddlePrice(@PathVariable low: Low, @PathVariable high: High): List<ThingDto> {
        return service.findAllThingsByMiddlePrice(low, high)
    }

    @Log
    override fun deleteById(@PathVariable id: Long): Int {
        return service.deleteById(id)
    }
}