package software.nipunatheekshana.shoe_shop_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Category;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO {
    private String supplierCode;
    private String name;
    private Category category;
    private String addressNo;
    private String lane;
    private String mainCity;
    private String mainState;
    private String postalCode;
    private String country;
    private String mobileNumber;
    private String landlineNumber;
    private String email;
}

