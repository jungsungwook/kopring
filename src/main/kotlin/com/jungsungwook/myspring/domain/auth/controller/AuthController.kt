package com.jungsungwook.myspring.domain.auth.controller
import com.jungsungwook.myspring.domain.auth.models.dto.SignUpDto
import com.jungsungwook.myspring.domain.auth.service.AuthService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
@RestController
class AuthController (
    private val authService: AuthService
){
    @PostMapping("/auth/signup")
    fun signUp(@RequestBody body: SignUpDto): String {
        authService.signUpByPost(body)
        return "sign-up"
    }

    @GetMapping("/auth/signin")
    fun signin(): String {
        return "hi"
    }
}