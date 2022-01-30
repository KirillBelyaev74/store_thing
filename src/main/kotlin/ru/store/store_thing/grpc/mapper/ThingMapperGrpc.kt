package ru.store.store_thing.grpc.mapper

import ru.store.store_thing.ThingOuterClass.*
import ru.store.store_thing.model.BrandCategorySizeDto
import ru.store.store_thing.model.ThingDto

object ThingMapperGrpc {

    fun thingResponseMapper(request: Thing?): ThingDto {
        return ThingDto(
            brand = request?.brand,
            category = request?.category,
            size = request?.size,
            price = request?.price,
            description = request?.description,
            id = -1
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
            Thing.newBuilder()
                .setId(it.id)
                .setBrand(it.brand)
                .setCategory(it.category)
                .setSize(it.size)
                .setPrice(it.price ?: -1)
                .setDescription(it.description)
                .build()
        }

        val status = Status.OK

        return ThingResponse.newBuilder()
            .setStatus(status)
            .addAllThing(things)
            .build()
    }

    fun brandCategorySizeDtoGrpcMapperOk(list: List<BrandCategorySizeDto>): BrandCategorySizeResponse {
        val results = list.map {
            BrandCategorySize.newBuilder()
                .setId(it.id)
                .setBrandCategorySize(it.brandCategorySize)
                .build()
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