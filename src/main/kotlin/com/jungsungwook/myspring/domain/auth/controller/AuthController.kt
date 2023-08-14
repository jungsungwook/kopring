package com.jungsungwook.myspring.domain.auth.controller
import com.jungsungwook.myspring.domain.auth.models.dto.*
import com.jungsungwook.myspring.domain.auth.service.AuthService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
@RestController
class AuthController (
    private val authService: AuthService
){
    @PostMapping("/auth/signup")
    fun signUp(@RequestBody body: SignUpRequestDto): SignUpResponseDto {
        return authService.signUpByPost(body)
    }

    @PostMapping("/auth/signin")
    fun signIn(@RequestBody body: SignInRequestDto): SignInResponseDto {
        return authService.signInByPost(body)
    }
}