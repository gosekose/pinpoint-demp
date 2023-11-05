package com.mdc.pinpoint.util

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class Logger {
    val log = LoggerFactory.getLogger(this.javaClass)!!
}