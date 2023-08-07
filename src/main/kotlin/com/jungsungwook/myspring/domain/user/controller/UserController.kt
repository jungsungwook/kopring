package com.jungsungwook.myspring.domain.user.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(

) {
    @GetMapping("/user")
    fun user(): String {
        return "user"
    }
}