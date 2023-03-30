package uz.uniquecode.licensingservice.services;

import org.springframework.stereotype.Service;
import uz.uniquecode.licensingservice.mapper.LicenseMapper;
import uz.uniquecode.licensingservice.model.License;
import uz.uniquecode.licensingservice.model.dto.LicenseDto;
import uz.uniquecode.licensingservice.repository.LicenseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicenseService {

    private final LicenseRepository repository;
    private final LicenseMapper mapper;


    public LicenseService(LicenseRepository repository, LicenseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public License getLicense(Long licenseId) {
        var response = repository.findById(licenseId);
        return response.get();
    }

    public License saveLicense(License license) {
        return repository.save(license);
    }

    public void updateLicense(License license) {
        saveLicense(license);
    }

    public void deleteLicense(License license) {
        repository.delete(license);
    }

    public List<LicenseDto> findAll() {
        List<LicenseDto> list = new ArrayList<>();
        List<License> resList = repository.findAll();

        for (License entity : resList)
            list.add(mapper.toDto(entity));

        return list;
    }

}
