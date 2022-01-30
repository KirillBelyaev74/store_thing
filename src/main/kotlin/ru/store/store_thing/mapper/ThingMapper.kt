package ru.store.store_thing.mapper

import org.springframework.jdbc.core.RowMapper
import ru.store.store_thing.model.ThingDto
import java.sql.ResultSet

class ThingMapper: RowMapper<ThingDto> {

    override fun mapRow(rs: ResultSet, rowNum: Int): ThingDto {
        return ThingDto(
                id = rs.getLong("id"),
                brand = rs.getString("brand"),
                category = rs.getString("category"),
                description = rs.getString("description"),
                size = rs.getString("size"),
                price = rs.getLong("price")
        )
    }
}