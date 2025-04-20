package com.autoever.servicea;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b")
public interface ServiceBClient {

    @GetMapping("/ip")
    String getServiceAIp();
}
