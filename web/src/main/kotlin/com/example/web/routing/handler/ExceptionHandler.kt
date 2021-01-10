package com.example.web.routing.handler

import com.example.exception.CustomException
import com.example.exception.RestCustomException
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestHandler {
    @ExceptionHandler(RestCustomException::class)
    fun handleCustomException(exception: RestCustomException): String =
        "RestCustomException handled by ExceptionHandler.kt::RestHandler"
}


@ControllerAdvice
class Handler {
    @ExceptionHandler(CustomException::class)
    fun handleCustomException(exception: Exception, model: Model): String {
        model.addAttribute("name", "CustomException")
        return "greeting"
    }
}