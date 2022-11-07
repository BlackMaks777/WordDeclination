package com.bft.task1.controllers

import com.bft.task1.services.DeclinationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spell")
class DeclinationController {
    private val service :DeclinationService = DeclinationService()

    @GetMapping("/{word}", produces = ["application/json;charset=UTF-8"])
    fun wordDeclination(@PathVariable("word") word : String):List<String>{
        return service.spell(word)
    }
}