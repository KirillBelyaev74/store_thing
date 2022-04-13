package ru.store.store_thing.grpc.mapper

import com.google.protobuf.Int64Value
import com.google.protobuf.StringValue
import ru.store.store_thing.ThingOuterClass.*
import ru.store.store_thing.model.BrandCategorySizeDto
import ru.store.store_thing.model.ThingDto

object ThingMapperGrpc {

    fun thingResponseMapper(thing: Thing?): ThingDto {
        return ThingDto(
            id = if (thing?.hasId() == true) thing.id.value else null,
            brand = if (thing?.hasBrand() == true) thing.brand.value else null,
            category = if (thing?.hasCategory() == true) thing.category.value else null,
            size = if (thing?.hasSize() == true) thing.size.value else null,
            price = if (thing?.hasPrice() == true) thing.price.value else null,
            description = if (thing?.hasDescription() == true) thing.description.value else null
        )
    }

    fun thingActionMapperOk(result: Int?): ThingResponse {
        return when(result) {
            1 -> ThingResponse.newBuilder().setStatus(Status.OK).build()
            else -> ThingResponse.newBuilder().setStatus(Status.BAD).build()
        }
    }

    fun thingDtoGrpcMapperOk(list: List<ThingDto>): ThingResponse {
        val things = list.map {
            Thing.newBuilder().apply {
                id = it.id?.let { Int64Value.of(it) }
                brand = it.brand?.let { StringValue.of(it) }
                category = it.category?.let { StringValue.of(it) }
                size = it.size?.let { StringValue.of(it) }
                price = it.price?.let { Int64Value.of(it) }
                description = it.description?.let { StringValue.of(it) }
            }.build()
        }

        val status = Status.OK

        return ThingResponse.newBuilder()
            .setStatus(status)
            .addAllThing(things)
            .build()
    }

    fun brandCategorySizeDtoGrpcMapperOk(list: List<BrandCategorySizeDto>): BrandCategorySizeResponse {
        val results = list.map {
            BrandCategorySize.newBuilder().apply {
                id = Int64Value.of(id.value)
                brandCategorySize = StringValue.of(it.brandCategorySize)
            }.build()
        }

        val status = Status.OK

        return BrandCategorySizeResponse.newBuilder()
            .addAllBrandCategorySize(results)
            .setStatus(status)
            .build()
    }

    fun thingDtoGrpcMapperError(e: Exception): ThingResponse {
        val errorResponse = Error.newBuilder()
            .setClass_(e::class.java.name)
            .setMessage(e.message ?: "Not data")
            .build()

        val status = Status.ERROR

        return ThingResponse.newBuilder()
            .setStatus(status)
            .setError(errorResponse)
            .build()
    }

    fun brandCategorySizeDtoGrpcMapperError(e: Exception): BrandCategorySizeResponse {
        val errorResponse = Error.newBuilder()
            .setClass_(e::class.java.name)
            .setMessage(e.message ?: "Not data")
            .build()

        val status = Status.ERROR

        return BrandCategorySizeResponse.newBuilder()
            .setStatus(status)
            .setError(errorResponse)
            .build()
    }
}