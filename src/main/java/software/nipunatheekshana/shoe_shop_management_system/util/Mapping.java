package software.nipunatheekshana.shoe_shop_management_system.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import software.nipunatheekshana.shoe_shop_management_system.dto.CustomerDTO;
import software.nipunatheekshana.shoe_shop_management_system.dto.EmployeeDTO;
import software.nipunatheekshana.shoe_shop_management_system.dto.ItemDTO;
import software.nipunatheekshana.shoe_shop_management_system.dto.SupplierDTO;
import software.nipunatheekshana.shoe_shop_management_system.entity.CustomerEntity;
import software.nipunatheekshana.shoe_shop_management_system.entity.EmployeeEntity;
import software.nipunatheekshana.shoe_shop_management_system.entity.ItemEntity;
import software.nipunatheekshana.shoe_shop_management_system.entity.SupplierEntity;


import java.util.List;

@Component
public class Mapping {
    private final ModelMapper mapper;

    Mapping(ModelMapper mapper) {
        this.mapper = mapper;
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //Customer Mapping
    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
        return mapper.map(customers, List.class);
    }

    //Supplier Mapping
    public SupplierDTO toSupplierDTO(SupplierEntity supplierEntity) {
        return  mapper.map(supplierEntity, SupplierDTO.class);
    }
    public SupplierEntity toSupplierEntity(SupplierDTO supplierDTO) {
        return  mapper.map(supplierDTO, SupplierEntity.class);
    }
    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> supplierEntities) {
        return mapper.map(supplierEntities, List.class);
    }

    //Employee Mapping
    public EmployeeDTO toEmployeeDTO(EmployeeEntity employeeEntity) {
        return  mapper.map(employeeEntity, EmployeeDTO.class);
    }
    public EmployeeEntity toEmployeeEntity(EmployeeDTO employeeDTO) {
        return  mapper.map(employeeDTO, EmployeeEntity.class);
    }
    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employeeEntities) {
        return mapper.map(employeeEntities, List.class);
    }

    //Item Mapping
    public ItemDTO toItemDTO(ItemEntity itemEntity) {
        return  mapper.map(itemEntity, ItemDTO.class);
    }
    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return  mapper.map(itemDTO, ItemEntity.class);
    }
    public List<ItemDTO> toItemDTOList(List<ItemEntity> itemEntities) {
        return mapper.map(itemEntities, List.class);
    }
}
