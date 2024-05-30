package software.nipunatheekshana.shoe_shop_management_system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSizeDTO {
    private Integer size;
    private Integer qty;
}