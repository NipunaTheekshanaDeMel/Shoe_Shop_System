package software.nipunatheekshana.shoe_shop_management_system.service;


import software.nipunatheekshana.shoe_shop_management_system.dto.InventoryDTO;


import java.util.List;

public interface InventoryService {
    void saveInventory(InventoryDTO inventoryDTO);
    List<InventoryDTO> getAllInventories();
    InventoryDTO getSelectedInventory(String inventoryId);
    void deleteInventory(String inventoryId);
    void updateInventory(String inventoryId, InventoryDTO inventoryDTO);
    List<InventoryDTO> getSortedInventories(String sortBy);
}