package com.example.web.routing

import com.example.domain.MyService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RequestPredicates
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.RouterFunctions.route
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.ok

@Configuration
class Router {

    @Bean
    fun home(service: MyService): RouterFunction<ServerResponse> =
        route()
            .nest(
                RequestPredicates.path("/route"),
                { builder ->
                    builder.GET("/greeting") { ok().body(service.greeting()) }
                    builder.GET("/greetingPage") { ok().render(service.homePageName(), mapOf("name" to "gen. Kenobi")) }
                }
            )
            .build()
}