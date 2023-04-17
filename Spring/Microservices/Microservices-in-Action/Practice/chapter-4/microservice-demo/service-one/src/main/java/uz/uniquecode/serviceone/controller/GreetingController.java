package uz.uniquecode.serviceone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface GreetingController {

    @GetMapping("/greeting/{username}")
    public ResponseEntity<?> greeting(@PathVariable(name = "username") String username);
}
