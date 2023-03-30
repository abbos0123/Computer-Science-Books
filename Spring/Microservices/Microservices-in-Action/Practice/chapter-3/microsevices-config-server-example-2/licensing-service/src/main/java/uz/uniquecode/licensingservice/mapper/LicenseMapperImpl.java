package uz.uniquecode.licensingservice.mapper;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import uz.uniquecode.licensingservice.model.License;
import uz.uniquecode.licensingservice.model.dto.LicenseDto;

/**
 * Author: Abbos Fayziboev
 * Date: 29/03/23
 * Email: abbosFayziboev@gmail.com
 */

@Component
public class LicenseMapperImpl implements LicenseMapper {
    @Override
    public License toEntity(LicenseDto dto) {
        License license = new License();
        license.setLicenseType(dto.getLicenseType());
        license.setOrganizationId(dto.getOrgId());
        license.setProductName(dto.getProductName());
        return license;
    }

    @Override
    public LicenseDto toDto(License entity) {
        LicenseDto dto = new LicenseDto();

        dto.setLicenseType(entity.getLicenseType());
        dto.setProductName(entity.getProductName());
        dto.setOrgId(entity.getId());
        dto.setId(entity.getId());
        return dto;
    }
}
