package software.nipunatheekshana.shoe_shop_management_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "item_size")
public class ItemSizeEntity {
    @Id
    private String itemSizeId;
    private Integer qty;
    private Double buyingPrice;
    private Double sellingPrice;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "itemCode", nullable = false)
    private ItemEntity itemEntity;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "sizeId", nullable = false)
    private SizeEntity sizeEntity;

//    @OneToMany(mappedBy = "itemSizeEntity")
//    @JsonManagedReference
//    private List<SaleDetailsEntity> saleDetailsEntities;
}
