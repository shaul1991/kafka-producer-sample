package com.example.kafkaproducersample

import com.example.kafkaproducersample.KafkaProducerConfiguration.Companion.TOPIC
import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class KafkaProducerController(val kafkaTemplate: KafkaTemplate<String, String>) {

    @GetMapping("/")
    fun main(): String {
        return "GET / OK"
    }

    @GetMapping("/producers/{id}")
    fun getProducer(@PathVariable id: Int): ResponseEntity<String> {
        val producerInfo = Optional.of(id)

        return if (producerInfo.isPresent) {
            kafkaTemplate.send(TOPIC, "GET /producers/{$id} OK")
            ResponseEntity.ok(producerInfo.get().toString())
        } else {
            kafkaTemplate.send(TOPIC, "GET /producers/{$id} BadRequest")
            ResponseEntity.badRequest().body(null)
        }
    }
}