package uz.uniquecode.microserviceone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uniquecode.microserviceone.service.MyService;

/**
 * Author: Abbos Fayziboev
 * Date: 31/03/23
 * Email: abbosFayziboev@gmail.com
 */

@RestController
@RequestMapping("/v1/api")
public class MyController {

    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping("/get-app-name")
    public ResponseEntity<?> getAppName() {
        return ResponseEntity.ok(service.getAppData());
    }
}
