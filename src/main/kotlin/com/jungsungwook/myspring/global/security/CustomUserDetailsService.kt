package com.jungsungwook.myspring.global.security

import com.jungsungwook.myspring.domain.user.models.entity.User
import com.jungsungwook.myspring.domain.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(customId: String): UserDetails {
        val user: User = userRepository.findByCustomId(customId) ?: throw IllegalArgumentException("존재하지 않는 username 입니다.")

        return CustomUserDetails(user)
    }

    fun loadUserByCustomId(customId: String): UserDetails {
        val user: User = userRepository.findByCustomId(customId) ?: throw IllegalArgumentException("존재하지 않는 username 입니다.")

        return CustomUserDetails(user)
    }
}