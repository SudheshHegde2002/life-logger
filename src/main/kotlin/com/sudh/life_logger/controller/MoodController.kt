package com.sudh.life_logger.controller

import com.sudh.life_logger.model.MoodEntry
import com.sudh.life_logger.repository.MoodRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/mood")
class MoodController(
    private val moodRepository: MoodRepository
) {

    @PostMapping
    fun logMood(@RequestBody moodEntry: MoodEntry): MoodEntry {
        return moodRepository.save(moodEntry)
    }

    @GetMapping
    fun getAllMoods(): List<MoodEntry> {
        return moodRepository.findAll()
    }
}
