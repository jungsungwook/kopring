package com.jungsungwook.myspring.domain.auth.service
import com.jungsungwook.myspring.domain.auth.models.dto.SignUpDto
import com.jungsungwook.myspring.domain.user.models.entity.User
import com.jungsungwook.myspring.domain.user.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
        private val userRepository: UserRepository,
        private val encoder: BCryptPasswordEncoder
) {
    fun signUpByPost(dto: SignUpDto) {
        var user: User = User(
                customId = dto.customId,
                email = dto.email,
                password = encoder.encode(dto.password),
                name = dto.name,
        )
        userRepository.save(user)
    }
}