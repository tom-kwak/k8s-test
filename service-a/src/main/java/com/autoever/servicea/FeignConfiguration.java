package com.autoever.servicea;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
