package com.example.domain

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Service

@Service
@EnableConfigurationProperties(ServiceProperties::class)
class MyService(private val serviceProperties: ServiceProperties) {

    fun homePageName(): String =
        serviceProperties.getHomePageName()

    fun greeting(): String = "Hello, General Kenobi"
}