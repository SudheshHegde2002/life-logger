package com.sudh.life_logger.model

data class KafkaActivityEvent(val activityType: String, val durationMinutes: Int, val timestamp: String)