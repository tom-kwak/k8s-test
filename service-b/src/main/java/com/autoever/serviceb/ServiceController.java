package com.autoever.serviceb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequiredArgsConstructor
public class ServiceController {


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
}
