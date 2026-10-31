package dev.shiroyasha.flat_tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlatTrackerApplication

fun main(args: Array<String>) {
	runApplication<FlatTrackerApplication>(*args)
}
