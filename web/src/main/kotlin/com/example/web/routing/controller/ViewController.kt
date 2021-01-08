package com.example.web.routing.controller

import com.example.service.MyService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController(private var service: MyService) {

    @GetMapping("/view/greeting")
    fun home(model: Model): String {
        model.addAttribute("name", "gen. Kenobi")
        return service.homePageName()
    }
}