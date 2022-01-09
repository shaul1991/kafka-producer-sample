package com.example.kafkaproducersample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaProducerSampleApplication

fun main(args: Array<String>) {
    runApplication<KafkaProducerSampleApplication>(*args)
}
