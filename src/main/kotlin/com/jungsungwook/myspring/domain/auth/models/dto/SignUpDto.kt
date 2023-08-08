package com.jungsungwook.myspring.domain.auth.models.dto

data class SignUpDto(
        val customId: String,
        val password: String,
        val name: String,
        val email: String
)
