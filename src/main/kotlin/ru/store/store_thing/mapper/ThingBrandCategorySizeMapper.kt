package ru.store.store_thing.mapper

import org.springframework.jdbc.core.RowMapper
import ru.store.store_thing.model.BrandCategorySizeDto
import java.sql.ResultSet

class ThingBrandCategorySizeMapper(private val nameColumn: String): RowMapper<BrandCategorySizeDto> {

    override fun mapRow(rs: ResultSet, rowNum: Int): BrandCategorySizeDto {
        return BrandCategorySizeDto(
            id = rs.getLong("id"),
            brandCategorySize = rs.getString(nameColumn)
        )
    }
}