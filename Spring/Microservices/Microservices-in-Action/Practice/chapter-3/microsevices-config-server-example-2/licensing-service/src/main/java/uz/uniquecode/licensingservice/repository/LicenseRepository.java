package uz.uniquecode.licensingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.uniquecode.licensingservice.model.License;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

    List<License> findAllByOrganizationId(String organizationId);
    List<License> findAllByLicenseType(String licenseType);
}
