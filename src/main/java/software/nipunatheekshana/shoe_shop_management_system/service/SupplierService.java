package software.nipunatheekshana.shoe_shop_management_system.service;

import software.nipunatheekshana.shoe_shop_management_system.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(String supplierCode);
    SupplierDTO getSelectedSupplier(String supplierCode);
    List<SupplierDTO> getAllSupplier();
    void updateSupplier(String supplierCode,SupplierDTO supplierDTO);
}
