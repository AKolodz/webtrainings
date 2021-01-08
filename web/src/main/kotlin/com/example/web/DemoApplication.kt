package com.example.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller

@SpringBootApplication(scanBasePackages = ["com.example"])
@Controller
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
