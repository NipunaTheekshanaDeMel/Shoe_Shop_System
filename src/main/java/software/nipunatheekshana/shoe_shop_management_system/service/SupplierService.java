package software.nipunatheekshana.shoe_shop_management_system.service;


import software.nipunatheekshana.shoe_shop_management_system.dto.SupplierDTO;


import java.util.List;

public interface SupplierService {
    void saveSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(String supplierId);
    SupplierDTO getSelectedSupplier(String supplierId);
    List<SupplierDTO> getAllSuppliers();
    void updateSupplier(String supplierId,SupplierDTO supplierDTO);
}