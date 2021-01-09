package com.example.web

import com.example.service.MyService
import com.example.web.routing.handler.SimpleHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Bean
    fun provideHandler(service: MyService) = SimpleHandler(service)
}