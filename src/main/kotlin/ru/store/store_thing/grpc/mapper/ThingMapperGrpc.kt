//package ru.store.store_thing.grpc.mapper
//
//import com.google.protobuf.Int64Value
//import com.google.protobuf.StringValue
//import ru.store.store_thing.ThingOuterClass.*
//import ru.store.store_thing.model.BrandCategorySizeDto
//import ru.store.store_thing.model.ThingDto
//
//object ThingMapperGrpc {
//
//    fun thingResponseMapper(thing: Thing?): ThingDto {
//        return ThingDto(
//            id = if (thing?.hasId() == true) thing.id.value else null,
//            brand = if (thing?.hasBrand() == true) thing.brand.value else null,
//            category = if (thing?.hasCategory() == true) thing.category.value else null,
//            size = if (thing?.hasSize() == true) thing.size.value else null,
//            price = if (thing?.hasPrice() == true) thing.price.value else null,
//            description = if (thing?.hasDescription() == true) thing.description.value else null
//        )
//    }
//
//    fun thingActionMapperOk(result: Int?): ThingResponse {
//        return when(result) {
//            1 -> ThingResponse.newBuilder().setStatus(Status.OK).build()
//            else -> ThingResponse.newBuilder().setStatus(Status.BAD).build()
//        }
//    }
//
//    fun thingDtoGrpcMapperOk(list: List<ThingDto>): ThingResponse {
//        val things = list.map {
//            Thing.newBuilder().apply {
//                it.id?.let { id = Int64Value.of(it) }
//                it.brand?.let { brand = StringValue.of(it) }
//                it.category?.let { category = StringValue.of(it) }
//                it.size?.let { size = StringValue.of(it) }
//                it.price?.let { price = Int64Value.of(it) }
//                it.description?.let { description = StringValue.of(it) }
//            }.build()
//        }
//
//        val status = Status.OK
//
//        return ThingResponse.newBuilder()
//            .setStatus(status)
//            .addAllThing(things)
//            .build()
//    }
//
//    fun brandCategorySizeDtoGrpcMapperOk(list: List<BrandCategorySizeDto>): BrandCategorySizeResponse {
//        val results = list.map {
//            BrandCategorySize.newBuilder().apply {
//                id = Int64Value.of(it.id)
//                it.brandCategorySize?.let { brandCategorySize = StringValue.of(it) }
//            }.build()
//        }
//
//        val status = Status.OK
//
//        return BrandCategorySizeResponse.newBuilder()
//            .addAllBrandCategorySize(results)
//            .setStatus(status)
//            .build()
//    }
//
//    fun thingDtoGrpcMapperError(e: Exception): ThingResponse {
//        val errorResponse = Error.newBuilder()
//            .setClass_(e::class.java.name)
//            .setMessage(e.message ?: "Not data")
//            .build()
//
//        val status = Status.ERROR
//
//        return ThingResponse.newBuilder()
//            .setStatus(status)
//            .setError(errorResponse)
//            .build()
//    }
//
//    fun brandCategorySizeDtoGrpcMapperError(e: Exception): BrandCategorySizeResponse {
//        val errorResponse = Error.newBuilder()
//            .setClass_(e::class.java.name)
//            .setMessage(e.message ?: "Not data")
//            .build()
//
//        val status = Status.ERROR
//
//        return BrandCategorySizeResponse.newBuilder()
//            .setStatus(status)
//            .setError(errorResponse)
//            .build()
//    }
//}