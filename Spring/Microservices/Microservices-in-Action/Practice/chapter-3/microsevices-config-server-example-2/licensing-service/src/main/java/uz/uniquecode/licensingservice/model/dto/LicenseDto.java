package uz.uniquecode.licensingservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Abbos Fayziboev
 * Date: 29/03/23
 * Email: abbosFayziboev@gmail.com
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LicenseDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("org_id")
    private Long orgId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("license_type")
    private String licenseType;
}
