package com.mdc.pinpoint.domain

import org.springframework.stereotype.Component

@Component
interface OrderUseCase {

    fun order()

    fun cancel()

}