package software.nipunatheekshana.shoe_shop_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Category;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "supplier")
@Entity
public class SupplierEntity implements SuperEntity{
    @Id
    private String supplierCode;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String addressNo;
    private String lane;
    private String mainCity;
    private String mainState;
    private String postalCode;
    private String country;
    private String mobileNumber;
    private String landlineNumber;
    @Column(unique = true)
    private String email;
}
