package software.nipunatheekshana.shoe_shop_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.nipunatheekshana.shoe_shop_management_system.dao.CustomerRepo;
import software.nipunatheekshana.shoe_shop_management_system.dao.ItemRepo;
import software.nipunatheekshana.shoe_shop_management_system.dao.SaleRepo;
import software.nipunatheekshana.shoe_shop_management_system.dto.AdminPanelDTO;
import software.nipunatheekshana.shoe_shop_management_system.entity.ItemEntity;
import software.nipunatheekshana.shoe_shop_management_system.service.AdminPanelService;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminPanelServiceIMPL implements AdminPanelService {

    private final SaleRepo saleRepo;
    private final ItemRepo itemRepo;
    private final CustomerRepo customerRepo;

    @Override
    public AdminPanelDTO getPanelData() {
        AdminPanelDTO adminPanelDTO = new AdminPanelDTO();
        adminPanelDTO.setTotalProfit(saleRepo.findTotalProfit());
        adminPanelDTO.setTotalSales(saleRepo.findTotalSales());
        adminPanelDTO.setVerityTypeQuantities(itemRepo.getVerityTypeQuantity());
        adminPanelDTO.setTotalCustomers((int) customerRepo.count());

        List<ItemEntity> itemEntities = itemRepo.findMostSoldItems();
        if (!itemEntities.isEmpty()) {
            ItemEntity itemEntity = itemEntities.get(0);
            adminPanelDTO.setMostSaleItem(itemEntity.getItemDesc());
            adminPanelDTO.setMostSaleItemPic(itemEntity.getItemPic());
        }

        return adminPanelDTO;
    }
}