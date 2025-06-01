package com.sudh.lifelogger.repository

import com.sudh.lifelogger.model.MoodEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MoodRepository : JpaRepository<MoodEntry, Long>