package software.nipunatheekshana.shoe_shop_management_system.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.nipunatheekshana.shoe_shop_management_system.dao.CustomerRepo;
import software.nipunatheekshana.shoe_shop_management_system.dto.CustomerDTO;
import software.nipunatheekshana.shoe_shop_management_system.entity.CustomerEntity;
import software.nipunatheekshana.shoe_shop_management_system.service.CustomerService;
import software.nipunatheekshana.shoe_shop_management_system.util.Mapping;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepo repo;
    private final Mapping mapping;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
//        customerDTO.setCustomerCode(UUID.randomUUID().toString());
        return mapping.toCustomerDTO(repo.save(mapping.toCustomer(customerDTO)));
    }

    @Override
    public void deleteCustomer(String customerId) {
        repo.delete(repo.getReferenceById(customerId));
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        return mapping.toCustomerDTO(repo.getReferenceById(customerId));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.toCustomerDTOList(repo.findAll());
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        CustomerEntity customer = repo.getReferenceById(customerId);
        customer.setName(customerDTO.getName());
        customer.setGender(customerDTO.getGender());
        customer.setJoinDate(customerDTO.getJoinDate());
        customer.setLevel(customerDTO.getLevel());
        customer.setTotalPoints(customerDTO.getTotalPoints());
        customer.setDob(customerDTO.getDob());
        customer.setAddressNo(customerDTO.getAddressNo());
        customer.setLane(customerDTO.getLane());
        customer.setMainCity(customerDTO.getMainCity());
        customer.setMainState(customerDTO.getMainState());
        customer.setPostalCode(customerDTO.getPostalCode());
        customer.setContactNumber(customerDTO.getContactNumber());

        customer.setEmail(customerDTO.getEmail());
        customer.setRecentPurchaseDate(customerDTO.getRecentPurchaseDate());
        repo.save(customer);
    }
}