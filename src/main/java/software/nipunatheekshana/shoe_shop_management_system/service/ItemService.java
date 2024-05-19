package software.nipunatheekshana.shoe_shop_management_system.service;

import software.nipunatheekshana.shoe_shop_management_system.dto.ItemDTO;


import java.util.List;

public interface ItemService {
    ItemDTO saveItem(ItemDTO itemDTO);
    void deleteItem(String itemId);
    ItemDTO getSelectedItem(String itemId);
    List<ItemDTO> getAllItem();
    void updateItem(String itemId,ItemDTO itemDTO);
}
