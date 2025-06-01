package com.sudh.lifelogger.controller

import com.sudh.lifelogger.model.MoodEntry
import com.sudh.lifelogger.repository.MoodRepository
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
