package com.example.web.routing.handler

import com.example.service.MyService
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse

class SimpleHandler(private val service: MyService) {
    fun renderHomePage(request: ServerRequest): ServerResponse =
        ServerResponse.ok().render("home")

    fun handleException(request: ServerRequest): ServerResponse =
        try {
            ServerResponse.ok().body(service.throwNPE())
        } catch (ex: NullPointerException) {
            ServerResponse.status(HttpStatus.PRECONDITION_FAILED).build()
        }

    fun providePDF(request: ServerRequest): ServerResponse = ServerResponse.ok().body("TODO: PDF is not served.")

}