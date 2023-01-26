package com.tme.orderservice.config

import com.p6spy.engine.spy.P6SpyOptions
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class P6SpyConfig {

    @PostConstruct
    fun setLongMessageFormat() {
        P6SpyOptions.getActiveInstance().logMessageFormat = P6spySqlFormatter::class.java.name
    }

}