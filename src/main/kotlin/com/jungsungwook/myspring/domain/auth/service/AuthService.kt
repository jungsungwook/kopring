package com.jungsungwook.myspring.domain.auth.service
import com.jungsungwook.myspring.domain.auth.models.dto.SignInDto
import com.jungsungwook.myspring.domain.auth.models.dto.SignUpDto
import com.jungsungwook.myspring.domain.user.models.entity.User
import com.jungsungwook.myspring.domain.user.repository.UserRepository
import com.jungsungwook.myspring.global.utils.TokenProvider
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AuthService(
        private val userRepository: UserRepository,
        private val encoder: BCryptPasswordEncoder,
        private val tokenProvider: TokenProvider
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

    fun signInByPost(dto: SignInDto): String {
        var user: User? = userRepository.findByCustomId(dto.customId)
                ?.takeIf { encoder.matches(dto.password, it.password) }
                ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        var token: String = tokenProvider.createToken(dto.customId)
        return token
    }
}