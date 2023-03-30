package uz.uniquecode.licensingservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.uniquecode.licensingservice.mapper.LicenseMapper;
import uz.uniquecode.licensingservice.mapper.LicenseMapperImpl;
import uz.uniquecode.licensingservice.model.License;
import uz.uniquecode.licensingservice.model.dto.LicenseDto;
import uz.uniquecode.licensingservice.repository.LicenseRepository;
import uz.uniquecode.licensingservice.services.LicenseService;

/**
 * Author: Abbos Fayziboev
 * Date: 29/03/23
 * Email: abbosFayziboev@gmail.com
 */

@RestController
@RequestMapping("/v1/api")
public class TestController {

    private final LicenseMapper mapper;
    private final LicenseService service;
    @Value("${app.data}")
    private String data;

    public TestController(LicenseMapperImpl mapper, LicenseService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/test")
    public String getData() {
        return data;
    }

    @PostMapping("/add/license")
    public ResponseEntity<?> addNewLicense(@RequestBody LicenseDto dto) {
        License res = service.saveLicense(mapper.toEntity(dto));
        return ResponseEntity.ok(res);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
