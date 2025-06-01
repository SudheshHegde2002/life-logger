package com.sudh.life_logger.model

import jakarta.persistance.*
import java.time.LocalDateTime

@Entity
data class MoodEntry(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,
    val moodLevel: Int,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val note: String? = null,
)