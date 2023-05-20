package com.springboot_example.springboot_example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class HelloWorldController {
  
    Counter visitCounter;

    public HelloWorldController(MeterRegistry registry) {
        visitCounter = Counter.builder("visit_counter")
            .description("Number of visits to the site")
            .register(registry);
    }
            
    @GetMapping("/")
    public String index() {
        visitCounter.increment();
        return "Hello World!";
    }
}
