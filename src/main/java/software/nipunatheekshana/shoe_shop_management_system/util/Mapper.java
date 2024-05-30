package software.nipunatheekshana.shoe_shop_management_system.util;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import software.nipunatheekshana.shoe_shop_management_system.dto.*;
import software.nipunatheekshana.shoe_shop_management_system.entity.*;


@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper mapper;

    //Customer Mapping
    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
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
    public ItemEntity toItemEntity(InventoryDTO inventoryDTO){
        return mapper.map(inventoryDTO, ItemEntity.class);
    }

    //User Mapping
    public UserEntity toUserEntity(UserDTO userDTO){
        return mapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }

    //Sale Mapping
    public SaleEntity toSaleEntity(SaleDTO saleDTO){
        return mapper.map(saleDTO, SaleEntity.class);
    }
    public SaleDTO toSaleDTO(SaleEntity saleEntity){
        return mapper.map(saleEntity, SaleDTO.class);
    }
    public List<SaleDTO> toSaleDTOList(List<SaleEntity> saleEntities){
        return mapper.map(saleEntities, List.class);
    }

    //Refund Mapping
    public RefundEntity toRefundEntity(RefundDTO refundDTO){
        return mapper.map(refundDTO, RefundEntity.class);
    }

}