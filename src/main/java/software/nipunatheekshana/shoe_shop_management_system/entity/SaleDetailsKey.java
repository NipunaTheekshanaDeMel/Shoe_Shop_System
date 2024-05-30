package software.nipunatheekshana.shoe_shop_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class SaleDetailsKey implements Serializable {
    @Column(name = "orderId")
    private String orderId;
    @Column(name = "itemSizeId")
    private String itemSizeId;
}