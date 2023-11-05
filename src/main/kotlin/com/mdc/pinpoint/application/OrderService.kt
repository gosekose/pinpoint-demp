package com.mdc.pinpoint.application

import com.mdc.pinpoint.domain.OrderUseCase
import com.mdc.pinpoint.util.Logger
import org.springframework.stereotype.Service

@Service
class OrderService : OrderUseCase {
    override fun order() {
        Thread.sleep(100L)
        log.info("OrderService order() 호출")
    }

    override fun cancel() {
        log.info("cancel!!!")
    }

    companion object : Logger()

}