package com.example.web.routing.controller

import com.example.service.MyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestToBeController(private var service: MyService) {

    @GetMapping("/rest/greeting")
    fun message() = service.greeting()
}