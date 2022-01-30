package ru.store.store_thing.service

import ru.store.store_thing.model.BrandCategorySizeDto
import ru.store.store_thing.model.ThingDto

interface IThingService {

    fun save(thing: ThingDto): Int

    fun findAllThings(): List<ThingDto>

    fun findAllCategory(): List<BrandCategorySizeDto>

    fun findAllBrand(): List<BrandCategorySizeDto>

    fun findAllSize(): List<BrandCategorySizeDto>

    fun findAllThingsByCategory(category: String): List<ThingDto>

    fun findAllThingsByBrand(brand: String): List<ThingDto>

    fun findAllThingsBySize(size: String): List<ThingDto>

    fun findAllThingsByMiddlePrice(low: Long, high: Long): List<ThingDto>

    fun deleteById(id: Long): Int
}