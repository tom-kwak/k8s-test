package com.autoever.servicea;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ServiceAController {

    private final ServiceBClient serviceBClient;

    @GetMapping("/ip")
    public String getMyIp() {
        try {
            String hostname = System.getenv("HOSTNAME");
            InetAddress containerIP = InetAddress.getByName(hostname);
            return """
                    HOST Name: %s, 
                    Container IP: %s
                    """.formatted(hostname, containerIP.getHostAddress());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/services/b/ip")
    public String getServiceBIp() {
        return serviceBClient.getServiceAIp();
    }
}
