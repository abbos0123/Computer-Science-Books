package uz.uniquecode.licensingservice.mapper;

import uz.uniquecode.licensingservice.model.License;
import uz.uniquecode.licensingservice.model.dto.LicenseDto;

public interface LicenseMapper {

    License toEntity(LicenseDto dto);
    LicenseDto toDto(License entity);
}
