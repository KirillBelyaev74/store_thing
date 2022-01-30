package ru.store.store_thing.model

class ThingDto(
        var id: Long,
        var brand: String? = null,
        var category: String? = null,
        var size: String? = null,
        var price: Long? = null,
        var description: String? = null
)