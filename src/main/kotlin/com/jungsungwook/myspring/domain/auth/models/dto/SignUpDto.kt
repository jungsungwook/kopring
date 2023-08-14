package com.jungsungwook.myspring.domain.auth.models.dto

data class SignUpRequestDto(
        val customId: String,
        val password: String,
        val name: String,
        val email: String
)

data class SignUpResponseDto(
        val statusCode: String,
        val content: String,
)