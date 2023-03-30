package uz.uniquecode.serviceone.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uniquecode.serviceone.service.MyServiceOne;

@RestController
@RequestMapping("/v1/api")
public class MyController {
    private final MyServiceOne serviceOne;

    public MyController(MyServiceOne serviceOne) {
        this.serviceOne = serviceOne;
    }

    @GetMapping("/message")
    public ResponseEntity<?> getMessage() {
        return ResponseEntity.ok(serviceOne.getMessageFromRemoteServer());
    }
}
