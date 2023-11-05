package com.mdc.pinpoint.api

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*

@Configuration
@ServletComponentScan
class MdcFilterConfig {

    @Bean
    fun mdcFilterRegistrationBean(): FilterRegistrationBean<OncePerRequestFilter> {
        val registrationBean = FilterRegistrationBean<OncePerRequestFilter>()

        registrationBean.filter = object : OncePerRequestFilter() {
            override fun doFilterInternal(
                request: HttpServletRequest,
                response: HttpServletResponse,
                filterChain: FilterChain
            ) {
                val requestId = UUID.randomUUID().toString()
                MDC.put("requestId", requestId)
                try {
                    filterChain.doFilter(request, response)
                } finally {
                    MDC.clear()
                }
            }
        }

        registrationBean.order = Ordered.HIGHEST_PRECEDENCE
        registrationBean.addUrlPatterns("/*")
        return registrationBean
    }
}