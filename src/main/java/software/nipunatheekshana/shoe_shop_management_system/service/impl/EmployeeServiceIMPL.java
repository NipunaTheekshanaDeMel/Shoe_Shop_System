package software.nipunatheekshana.shoe_shop_management_system.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.nipunatheekshana.shoe_shop_management_system.dao.EmployeeRepo;
import software.nipunatheekshana.shoe_shop_management_system.dto.EmployeeDTO;
import software.nipunatheekshana.shoe_shop_management_system.entity.EmployeeEntity;
import software.nipunatheekshana.shoe_shop_management_system.exception.NotFoundException;
import software.nipunatheekshana.shoe_shop_management_system.service.EmployeeService;
import software.nipunatheekshana.shoe_shop_management_system.util.Mapper;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final Mapper mapper;

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeId(UUID.randomUUID().toString());
        employeeRepo.save(mapper.toEmployeeEntity(employeeDTO));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return mapper.toEmployeeDTOList(employeeRepo.findAll());
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String id) {
        if (!employeeRepo.existsById(id)) throw new NotFoundException("Employee not found");
        return mapper.toEmployeeDTO(employeeRepo.getReferenceById(id));
    }

    @Override
    public void deleteEmployee(String id) {
        if (!employeeRepo.existsById(id)) throw new NotFoundException("Employee not found");
        employeeRepo.deleteById(id);
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> employeeEntity = employeeRepo.findById(id);
        if (employeeEntity.isEmpty()) throw new NotFoundException("Employee not found");
        employeeEntity.get().setName(employeeDTO.getName());
        employeeEntity.get().setGender(employeeDTO.getGender());
        employeeEntity.get().setCivilState(employeeDTO.getCivilState());
        employeeEntity.get().setDesignation(employeeDTO.getDesignation());
        employeeEntity.get().setDob(employeeDTO.getDob());
        employeeEntity.get().setJoinedDate(employeeDTO.getJoinedDate());
        employeeEntity.get().setAddress(employeeDTO.getAddress());
        employeeEntity.get().setContact(employeeDTO.getContact());
        employeeEntity.get().setEmail(employeeDTO.getEmail());
        employeeEntity.get().setGuardian(employeeDTO.getGuardian());
        employeeEntity.get().setEmergencyContact(employeeDTO.getEmergencyContact());
    }

}