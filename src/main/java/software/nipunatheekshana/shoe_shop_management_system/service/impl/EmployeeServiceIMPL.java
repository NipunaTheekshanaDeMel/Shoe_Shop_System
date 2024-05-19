package software.nipunatheekshana.shoe_shop_management_system.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.nipunatheekshana.shoe_shop_management_system.dao.EmployeeRepo;
import software.nipunatheekshana.shoe_shop_management_system.dto.EmployeeDTO;
import software.nipunatheekshana.shoe_shop_management_system.service.EmployeeService;
import software.nipunatheekshana.shoe_shop_management_system.util.Mapping;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeRepo repo;
    private final Mapping mapping;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
//        employeeDTO.setEmployeeCode(UUID.randomUUID().toString());
        return mapping.toEmployeeDTO(repo.save(mapping.toEmployeeEntity(employeeDTO)));
    }

    @Override
    public void deleteEmployee(String employeeId) {
        repo.delete(repo.getReferenceById(employeeId));
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String employeeId) {
        return mapping.toEmployeeDTO(repo.getReferenceById(employeeId));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return mapping.toEmployeeDTOList(repo.findAll());
    }

    @Override
    public void updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        repo.save(mapping.toEmployeeEntity(employeeDTO));
    }
}
