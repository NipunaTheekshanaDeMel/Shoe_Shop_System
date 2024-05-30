package software.nipunatheekshana.shoe_shop_management_system.service;


import software.nipunatheekshana.shoe_shop_management_system.dto.CustomerDTO;


import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO getSelectedCustomer(String customerId);
    List<CustomerDTO> getAllCustomers();
    void updateCustomer(String customerId,CustomerDTO customerDTO);
    CustomerDTO getCustomerByContact(String contact);
}