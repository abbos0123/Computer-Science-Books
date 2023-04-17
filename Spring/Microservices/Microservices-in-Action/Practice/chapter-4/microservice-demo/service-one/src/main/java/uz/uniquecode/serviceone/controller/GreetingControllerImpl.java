package uz.uniquecode.serviceone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerImpl implements GreetingController {

    @Override
    public ResponseEntity<?> greeting(String username) {
        return ResponseEntity.ok(String.format("Hello %s!\n", username));
    }
}
