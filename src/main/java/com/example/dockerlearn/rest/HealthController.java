package com.example.dockerlearn.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Map<String, Object> getHealth() {
        log.debug("get health status");
        System.out.println("get health status");
        return Map.of("status", "OK");
    }

}
