package com.example.web.dao

import com.example.domain.Cat
import org.springframework.stereotype.Repository

@Repository
class CatDAO(private var cats: List<Cat> = mutableListOf()) {


    fun add(cat: Cat) {
        cats.plus(cat)
    }

    fun getCats(): List<Cat> {
        return cats
    }
}