package uz.uniquecode.servicetwo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uniquecode.servicetwo.service.MyServiceTwo;

@RestController
@RequestMapping("/v1/api")
public class MyController {
    private final MyServiceTwo serviceOne;

    public MyController(MyServiceTwo serviceTwo) {
        this.serviceOne = serviceTwo;
    }

    @GetMapping("/message")
    public ResponseEntity<?> getMessage() {
        return ResponseEntity.ok(serviceOne.getMessageFromRemoteServer());
    }
}
