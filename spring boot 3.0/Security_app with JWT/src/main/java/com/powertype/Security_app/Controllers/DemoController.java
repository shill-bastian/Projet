package com.powertype.Security_app.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class DemoController {

    @GetMapping("/demo-controller")
    public ResponseEntity<String> helloWorld(){
        return  ResponseEntity.ok("Hello there i'm a token secured page !!");

    }
}
