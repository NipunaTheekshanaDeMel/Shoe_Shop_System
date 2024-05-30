package software.nipunatheekshana.shoe_shop_management_system.dto;

import lombok.Getter;
import lombok.Setter;
import software.nipunatheekshana.shoe_shop_management_system.entity.enums.VerityType;


@Getter
@Setter

public class VerityTypeQuantity {
    private VerityType verityType;
    private Integer quantity;

    public VerityTypeQuantity(VerityType verityType, double quantity) {
        this.verityType = verityType;
        this.quantity = (int) quantity;
    }
}