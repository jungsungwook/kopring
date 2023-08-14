package com.jungsungwook.myspring.domain.auth.models.dto

data class SignInRequestDto(
        val customId: String,
        val password: String,
)

data class SignInResponseDto(
        val statusCode: String,
        val content: String,
)