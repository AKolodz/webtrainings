package com.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.junit.jupiter.api.Test


@SpringBootTest("service.message=Hello")
class MyServiceTest {
    @Autowired
    private lateinit var myService : MyService

    @Test
    fun contextLoads() {
        print(myService.homePageName())
        assertThat(myService.homePageName()).isNotNull
    }
    @SpringBootApplication
    internal class TestConfiguration
}