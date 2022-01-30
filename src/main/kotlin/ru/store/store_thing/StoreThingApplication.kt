package ru.store.store_thing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class StoreThingApplication

fun main(args: Array<String>) {
	runApplication<StoreThingApplication>(*args)
}

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }