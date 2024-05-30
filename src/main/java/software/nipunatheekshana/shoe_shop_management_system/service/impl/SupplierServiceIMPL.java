package software.nipunatheekshana.shoe_shop_management_system.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.nipunatheekshana.shoe_shop_management_system.dao.SupplierRepo;
import software.nipunatheekshana.shoe_shop_management_system.dto.SupplierDTO;
import software.nipunatheekshana.shoe_shop_management_system.service.SupplierService;
import software.nipunatheekshana.shoe_shop_management_system.util.Mapping;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {

    private final SupplierRepo repo;
    private final Mapping mapping;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
//        supplierDTO.setSupplierCode(UUID.randomUUID().toString());
        return mapping.toSupplierDTO(repo.save(mapping.toSupplierEntity(supplierDTO)));
    }

    @Override
    public void deleteSupplier(String supplierCode) {
        repo.delete(repo.getReferenceById(supplierCode));
    }

    @Override
    public SupplierDTO getSelectedSupplier(String supplierCode) {
        return mapping.toSupplierDTO(repo.getReferenceById(supplierCode));
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return mapping.toSupplierDTOList(repo.findAll());
    }

    @Override
    public void updateSupplier(String supplierCode, SupplierDTO supplierDTO) {
        repo.save(mapping.toSupplierEntity(supplierDTO));
    }
}
