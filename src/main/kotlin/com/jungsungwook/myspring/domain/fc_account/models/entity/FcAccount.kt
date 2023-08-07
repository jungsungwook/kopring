package com.jungsungwook.myspring.domain.fc_account.models.entity
import com.jungsungwook.myspring.domain.user.models.entity.User
import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "fc_account")
class FcAccount(user: User, account_id: String, account_name: String){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var accountId: String = account_id

    @Column(name = "email", nullable = false)
    var accountName: String = account_name

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User = user

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
