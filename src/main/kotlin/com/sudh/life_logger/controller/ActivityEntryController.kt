package com.sudh.life_logger.controller

import com.sudh.life_logger.model.ActivityEntry
import com.sudh.life_logger.repository.ActivityEntryRepository
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/activity")
@CrossOrigin
class ActivityEntryController(private val repo: ActivityEntryRepository) {

    @PostMapping
    fun addEntry(@RequestBody entry: ActivityEntry): ActivityEntry {
        return repo.save(entry)
    }

    @GetMapping
    fun getAll(): List<ActivityEntry> = repo.findAll()
}