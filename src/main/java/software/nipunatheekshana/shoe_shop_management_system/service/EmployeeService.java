package software.nipunatheekshana.shoe_shop_management_system.service;

import software.nipunatheekshana.shoe_shop_management_system.dto.EmployeeDTO;


import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(String employeeId);
    EmployeeDTO getSelectedEmployee(String employeeId);
    List<EmployeeDTO> getAllEmployee();
    void updateEmployee(String employeeId,EmployeeDTO employeeDTO);
}
