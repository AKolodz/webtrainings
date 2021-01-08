package com.example.service.util

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("service")
class ServiceProperties {
    private var homePageName: String = "default"

    fun getHomePageName() = homePageName

    fun setHomePageName(message: String) {
        this.homePageName = message
    }
}