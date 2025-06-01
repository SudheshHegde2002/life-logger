package com.sudh.life_logger
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableKafka
@SpringBootApplication
class LifeLoggerApplication

fun main(args: Array<String>) {
	runApplication<LifeLoggerApplication>(*args)
}
