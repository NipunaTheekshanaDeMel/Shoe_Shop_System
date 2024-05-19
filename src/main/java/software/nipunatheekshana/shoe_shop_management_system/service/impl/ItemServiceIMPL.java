package software.nipunatheekshana.shoe_shop_management_system.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.nipunatheekshana.shoe_shop_management_system.dao.ItemRepo;
import software.nipunatheekshana.shoe_shop_management_system.dto.ItemDTO;
import software.nipunatheekshana.shoe_shop_management_system.service.ItemService;
import software.nipunatheekshana.shoe_shop_management_system.util.Mapping;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceIMPL implements ItemService {
    private final ItemRepo repo;
    private final Mapping mapping;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
//        itemDTO.setItemCode(UUID.randomUUID().toString());
        return mapping.toItemDTO(repo.save(mapping.toItemEntity(itemDTO)));
    }

    @Override
    public void deleteItem(String itemId) {
        repo.delete(repo.getReferenceById(itemId));
    }

    @Override
    public ItemDTO getSelectedItem(String itemId) {
        return mapping.toItemDTO(repo.getReferenceById(itemId));
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return mapping.toItemDTOList(repo.findAll());
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        repo.save(mapping.toItemEntity(itemDTO));
    }
}
