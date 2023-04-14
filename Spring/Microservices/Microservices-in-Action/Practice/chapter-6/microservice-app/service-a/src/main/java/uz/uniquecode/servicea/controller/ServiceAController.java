package uz.uniquecode.servicea.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uniquecode.servicea.model.Poet;
import uz.uniquecode.servicea.model.Tale;
import uz.uniquecode.servicea.service.ServiceA;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@RestController
@RequestMapping("/api/service-a")
@RequiredArgsConstructor
public class ServiceAController {
    @Value("${spring.application.name}")
    String name;

    private final ServiceA service;

    @GetMapping("/all")
    public ResponseEntity<?> findAllData() {
        List<Object> list = new ArrayList<>(service.getAllPoets());
        list.addAll(service.getAllTales());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPoetAndTaleWithId(@PathVariable(name = "id") int id) {
        List<Object> list = new ArrayList<>();
        Object tale = service.getTaleById(id);
        Object poet = service.getPoetById(id);

        if (tale != null) list.add(tale);
        if (poet != null) list.add(poet);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/name")
    public ResponseEntity<?> findNameOfService(){
        return ResponseEntity.ok(name);
    }
}
