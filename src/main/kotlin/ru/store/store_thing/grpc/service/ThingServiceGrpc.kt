package ru.store.store_thing.grpc.service

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import ru.store.store_thing.ThingOuterClass
import ru.store.store_thing.ThingOuterClass.Request
import ru.store.store_thing.ThingOuterClass.ThingResponse
import ru.store.store_thing.ThingServiseGrpc
import ru.store.store_thing.grpc.mapper.ThingMapperGrpc
import ru.store.store_thing.service.IThingService

@GrpcService
class ThingServiceGrpc(private val service: IThingService) : ThingServiseGrpc.ThingServiseImplBase() {

    override fun saveThing(
        request: ThingOuterClass.Thing?,
        responseObserver: StreamObserver<ThingResponse>?
    ) {
        try {
            val result = service.save(ThingMapperGrpc.thingResponseMapper(request))
            val response = ThingMapperGrpc.thingActionMapperOk(result)
            responseObserver?.onNext(response)
        } catch (e: Exception) {
            val responseException = ThingMapperGrpc.thingDtoGrpcMapperError(e)
            responseObserver?.onNext(responseException)
        }
        responseObserver?.onCompleted()
    }

    override fun getAllThings(
        request: Request?,
        responseObserver: StreamObserver<ThingResponse>?
    ) {
        try {
            val list = service.findAllThings()
            val response = ThingMapperGrpc.thingDtoGrpcMapperOk(list)
            responseObserver?.onNext(response)
        } catch (e: Exception) {
            val responseException = ThingMapperGrpc.thingDtoGrpcMapperError(e)
            responseObserver?.onNext(responseException)
        }
        responseObserver?.onCompleted()
    }

    override fun getAllBrandCategorySizeResponse(
        request: Request?,
        responseObserver: StreamObserver<ThingOuterClass.BrandCategorySizeResponse>?
    ) {
        try {
            val listResult = when (request?.name) {
                "brand" -> service.findAllBrand()
                "category" -> service.findAllCategory()
                "size" -> service.findAllSize()
                else -> throw IllegalArgumentException("So argument doest not exist: ${request?.name}")
            }
            val response = ThingMapperGrpc.brandCategorySizeDtoGrpcMapperOk(listResult)
            responseObserver?.onNext(response)
        } catch (e: Exception) {
            val responseException = ThingMapperGrpc.brandCategorySizeDtoGrpcMapperError(e)
            responseObserver?.onNext(responseException)
        }
        responseObserver?.onCompleted()
    }

    override fun getAllThingsByBrandCategorySize(
        request: Request?,
        responseObserver: StreamObserver<ThingResponse>?
    ) {
        try {
            val listResult = when (request?.name) {
                "brand" -> service.findAllThingsByBrand(request.value)
                "category" -> service.findAllThingsByCategory(request.value)
                "size" -> service.findAllThingsBySize(request.value)
                else -> throw IllegalArgumentException("So argument doest not exist: ${request?.name}")
            }
            val response = ThingMapperGrpc.thingDtoGrpcMapperOk(listResult)
            responseObserver?.onNext(response)
        } catch (e: Exception) {
            val responseException = ThingMapperGrpc.thingDtoGrpcMapperError(e)
            responseObserver?.onNext(responseException)
        }
        responseObserver?.onCompleted()
    }

    override fun deleteThingById(
        request: ThingOuterClass.Thing?,
        responseObserver: StreamObserver<ThingResponse>?
    ) {
        try {
            val result = request?.id?.let { service.deleteById(it) }
            val response = ThingMapperGrpc.thingActionMapperOk(result)
            responseObserver?.onNext(response)
        } catch (e: Exception) {
            val responseException = ThingMapperGrpc.thingDtoGrpcMapperError(e)
            responseObserver?.onNext(responseException)
        }
        responseObserver?.onCompleted()
    }
}