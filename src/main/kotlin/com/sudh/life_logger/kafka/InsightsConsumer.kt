package com.sudh.life_logger.kafka

import com.sudh.life_logger.model.KafkaMoodEvent
import com.sudh.life_logger.model.KafkaActivityEvent
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class InsightsConsumer {

    private var moodSum = 0
    private var moodCount = 0
    private val activityCount = mutableMapOf<String, Int>()

    @KafkaListener(topics = ["mood-events"], groupId = "insight-group")
    fun consumeMood(event: KafkaMoodEvent) {
        moodSum += event.moodLevel
        moodCount++
    }

    @KafkaListener(topics = ["activity-events"], groupId = "insight-group")
    fun consumeActivity(event: KafkaActivityEvent) {
        activityCount[event.activityType] = activityCount.getOrDefault(event.activityType, 0) + 1
    }

    fun getInsights(): Map<String, Any> = mapOf(
        "averageMood" to if (moodCount == 0) 0 else moodSum.toDouble() / moodCount,
        "topActivity" to activityCount.maxByOrNull { it.value }?.key.orEmpty()
    )
}
