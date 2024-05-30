package software.nipunatheekshana.shoe_shop_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.Gender;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.OccasionType;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.VerityType;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "item")
@Entity
public class ItemEntity implements SuperEntity{
    @Id
    private String itemCode;
    private String itemDesc;
    @Column(columnDefinition = "LONGTEXT")
    private String itemPic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private OccasionType occasionType;
    @Enumerated(EnumType.STRING)
    private VerityType verityType;
    private Double buyingPrice;
    private Double sellingPrice;
    @OneToMany(mappedBy = "itemEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemSizeEntity> itemSizeEntities;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "supplierId", nullable = false)
    private SupplierEntity supplierEntity;
}