package com.sudh.life_logger.repository

import com.sudh.life_logger.model.MoodEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MoodRepository : JpaRepository<MoodEntry, Long>