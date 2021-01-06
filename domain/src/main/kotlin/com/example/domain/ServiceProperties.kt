package com.example.domain

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("service")
class ServiceProperties {
    private var message: String = "default"

    fun getMessage() = message

    fun setMessage(message: String) {
        this.message = message;
    }
}