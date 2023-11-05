package com.mdc.pinpoint

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PinpointApplication

fun main(args: Array<String>) {
    runApplication<PinpointApplication>(*args)
}
