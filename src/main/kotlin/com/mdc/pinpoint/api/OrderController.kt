package com.mdc.pinpoint.api

import com.mdc.pinpoint.domain.OrderUseCase
import com.mdc.pinpoint.util.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderUseCase: OrderUseCase,
) {

    @GetMapping("/order")
    fun order(): String {

        log.info("orderController order() 호출")

        orderUseCase.order()
        return "ok"
    }

    companion object : Logger()

}