package software.nipunatheekshana.shoe_shop_management_system.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Category;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "supplier")
@Entity
public class SupplierEntity implements SuperEntity{
    @Id
    private String supplierId;
    private String supplierName;
    @Enumerated(EnumType.STRING)
    private Category supplierCategory;
    private String address;
    private String contact1;
    private String contact2;
    private String email;
    @OneToMany(mappedBy = "supplierEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemEntity> itemEntities;
}