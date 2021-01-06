package com.example.web

import com.example.domain.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication(scanBasePackages = ["com.example"])
@Controller
class DemoApplication {

    @Autowired
    private lateinit var service: MyService

    @GetMapping("/")
    fun home(): String {
        return service.message()
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
