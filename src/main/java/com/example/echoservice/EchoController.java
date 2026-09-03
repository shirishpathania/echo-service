package com.example.echoservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EchoController {

    @PostMapping("/echo")
    public Map<String, Object> echo(@RequestBody Map<String, Object> requestBody) {
        return requestBody;
    }
}