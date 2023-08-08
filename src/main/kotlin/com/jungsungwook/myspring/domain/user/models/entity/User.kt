package com.jungsungwook.myspring.domain.user.models.entity
import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "user")
class User(name: String, email: String, customId: String, password: String){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "custom_id", nullable = false)
    var customId: String = customId

    @Column(name = "name", nullable = false)
    var name: String = name

    @Column(name = "email", nullable = false)
    var email: String = email

    @Column(name = "password", nullable = false)
    var password: String = password

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime? = null

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null

    @PrePersist
    fun prePersist() {
        val now = LocalDateTime.now()
        createdAt = now
        updatedAt = now
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}
