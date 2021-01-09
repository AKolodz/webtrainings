package com.example.web.routing

import com.example.service.MyService
import com.example.web.routing.handler.SimpleHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.RequestPredicates.GET
import org.springframework.web.servlet.function.RequestPredicates.path
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.RouterFunctions.nest
import org.springframework.web.servlet.function.RouterFunctions.route
import org.springframework.web.servlet.function.ServerResponse

/***
//Mapped /route => {
//    (GET && /greeting) -> com.example.web.routing.Router$home$1@61608e1a
//    (GET && /exception) -> com.example.web.routing.Router$home$2@7c46c9c3
//    (GET && /customException) -> com.example.web.routing.Router$home$3@7197b07f
//    (GET && /page) => {
//        (GET && ) -> com.example.web.routing.Router$home$4@1f10fec6
//        (GET && /{name}) -> com.example.web.routing.Router$home$5@7a65a360
//    }
//}
// /handle
//
// How to read a code:
// nest under path /route following router function:
//    /greeting and /exception and /customException and nested under /page following router function
//        / and /{name}
 ***/

@Configuration
class Router {

    @Bean
    fun provideRoutingToService(service: MyService): RouterFunction<ServerResponse> =
        nest(path("/route"),
            route(GET("/greeting"), { ServerResponse.ok().body(service.greeting()) })
                .andRoute(GET("/exception"), {
                    ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.throwNPE())
                })
                .andRoute(GET("/customException")) { ServerResponse.ok().body("CustomException") }
                .andNest(
                    GET("/page"),
                    route(GET(""), {
                        ServerResponse.ok().render(service.homePageName(), mapOf("name" to "gen. Kenobi"))
                    })
                        .andRoute(GET("/{name}")) {
                            ServerResponse.ok().render(service.homePageName(), mapOf("name" to it.pathVariable("name")))
                        }
                )
        )

    @Bean
    fun provideRoutingToHandler(handler: SimpleHandler): RouterFunction<ServerResponse> =
        route(GET("/route/handledException"), handler::handleException)
            .andRoute(GET("/"), handler::renderHomePage)
            .andRoute(GET("/pdf"), handler::providePDF)
}