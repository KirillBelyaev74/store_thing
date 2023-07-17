package ru.store.store_thing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.store.store_thing.model.ThingDto

@SpringBootApplication
open class StoreThingApplication

fun main(args: Array<String>) {
	runApplication<StoreThingApplication>(*args)
}

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }

typealias Low = Long
typealias High = Long