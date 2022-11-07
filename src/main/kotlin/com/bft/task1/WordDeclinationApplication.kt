package com.bft.task1

import com.bft.task1.services.DeclinationService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WordDeclinationApplication

fun main(args: Array<String>) {
	runApplication<WordDeclinationApplication>(*args)
}
