package com.jungsungwook.myspring.domain.auth.service
import com.jungsungwook.myspring.domain.auth.models.dto.*
import com.jungsungwook.myspring.domain.user.models.entity.User
import com.jungsungwook.myspring.domain.user.repository.UserRepository
import com.jungsungwook.myspring.global.security.TokenProvider
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
    fun signUpByPost(dto: SignUpRequestDto): SignUpResponseDto {
        val user: User = User(
                customId = dto.customId,
                email = dto.email,
                password = encoder.encode(dto.password),
                name = dto.name,
        )
        userRepository.save(user)
        return SignUpResponseDto("200", "Success")
    }

    fun signInByPost(dto: SignInRequestDto): SignInResponseDto {
        var user: User? = userRepository.findByCustomId(dto.customId)
                ?.takeIf { encoder.matches(dto.password, it.password) }
                ?: throw IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")
        val token: String = tokenProvider.createToken(dto.customId)
        return SignInResponseDto("200",token)
    }

    fun validateCheckByToken(token: String): Boolean {
        return tokenProvider.validateToken(token)
    }

    fun getCustomIdByToken(token: String): String {
        return tokenProvider.getUserPk(token)
    }

    fun getUserByTokenWithAuth(token: String): User {
        if(validateCheckByToken(token)){
            val customId = tokenProvider.getUserPk(token)
            return  userRepository.findByCustomId(customId)
                    ?: throw IllegalArgumentException("존재하지 않는 유저입니다.")
        }
        else{
            throw IllegalArgumentException("유효하지 않은 토큰입니다.")
        }
    }
}