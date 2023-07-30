package org.example.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(value = "/welcome")
    public ResponseEntity welcomeEndpoint() {

        return ResponseEntity.ok("Welcome to test page! Everything started ok");
    }
}
