package ru.store.store_thing.model

import ru.logging.annotation.LogFieldSkip
import ru.logging.model.ObjectToStringForLog

class ThingDto(
    @LogFieldSkip
    var id: Long? = null,
    var brand: String? = null,
    var category: String? = null,
    var size: String? = null,
    var price: Long? = null,
    var description: String? = null
) : ObjectToStringForLog()