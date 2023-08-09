package com.jungsungwook.myspring.domain.user.repository
import com.jungsungwook.myspring.domain.user.models.entity.User
import org.springframework.data.repository.CrudRepository
interface UserRepository : CrudRepository<User, String> {
    fun findByCustomId(customId: String): User?
}