package com.sudh.life_logger.controller

import com.sudh.life_logger.model.MoodEntry
import com.sudh.life_logger.repository.MoodRepository
import com.sudh.life_logger.model.KafkaMoodEvent
import org.springframework.web.bind.annotation.*
import org.springframework.kafka.core.KafkaTemplate

@RestController
@RequestMapping("/api/mood")
@CrossOrigin
class MoodController(
    private val moodRepository: MoodRepository,
    private val kafkaTemplate: KafkaTemplate<String, KafkaMoodEvent> // inject Kafka here
) {

    @PostMapping
    fun logMood(@RequestBody moodEntry: MoodEntry): MoodEntry {
        val saved = moodRepository.save(moodEntry)
        kafkaTemplate.send("mood-events", KafkaMoodEvent(saved.moodLevel, saved.timestamp.toString()))
        return saved
    }

    @GetMapping
    fun getAllMoods(): List<MoodEntry> = moodRepository.findAll()
}
