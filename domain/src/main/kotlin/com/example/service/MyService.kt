package com.example.service

import com.example.exception.CustomException
import com.example.exception.RestCustomException
import com.example.service.util.ServiceProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Service

@Service
@EnableConfigurationProperties(ServiceProperties::class)
class MyService(private val serviceProperties: ServiceProperties) {

    fun homePageName(): String = serviceProperties.getHomePageName()

    fun greeting(): String = "Hello, General Kenobi"

    fun throwNPE(): String {
        val result: String? = null
        return result ?: throw NullPointerException("Something was null")
    }

    fun throwCustomEx(): String {
        val result: String? = null
        return result ?: throw CustomException("Something was wrong in @Controller")
    }

    fun throwRestCustomEx(): String {
        val result: String? = null
        return result ?: throw RestCustomException("Something was wrong in @RestController")
    }

}