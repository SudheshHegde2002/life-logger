package com.sudh.life_logger.controller

import com.sudh.life_logger.kafka.InsightsConsumer
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/insights")
@CrossOrigin
class InsightsController(
    private val insightsConsumer: InsightsConsumer
) {

    @GetMapping
    fun getInsights(): Map<String, Any> {
        return insightsConsumer.getInsights()
    }
}
