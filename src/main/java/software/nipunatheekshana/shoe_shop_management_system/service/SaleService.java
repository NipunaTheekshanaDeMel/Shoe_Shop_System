package software.nipunatheekshana.shoe_shop_management_system.service;


import software.nipunatheekshana.shoe_shop_management_system.dto.RefundDTO;
import software.nipunatheekshana.shoe_shop_management_system.dto.SaleDTO;
import software.nipunatheekshana.shoe_shop_management_system.dto.SaleDetailsDTO;


import java.util.List;

public interface SaleService {
    void saveSale(SaleDTO saleDTO);
    List<SaleDTO> getAllSales();
    List<SaleDetailsDTO> getSelectedSale(String id);
    void saveRefund(RefundDTO refundDTO);

}