package com.sudh.life_logger.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ActivityEntry(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val activityType: String,
    val durationMinutes: Int,
    val timestamp: LocalDateTime
)
