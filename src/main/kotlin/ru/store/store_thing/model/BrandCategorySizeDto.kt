package ru.store.store_thing.model

import ru.logging.annotation.LogFieldSkip
import ru.logging.model.ObjectToStringForLog

data class BrandCategorySizeDto(
    @LogFieldSkip
    val id: Long,
    val brandCategorySize: String? = null
) : ObjectToStringForLog()
