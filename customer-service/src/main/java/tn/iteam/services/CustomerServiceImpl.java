package tn.iteam.services;

import org.springframework.stereotype.Service;
import tn.iteam.dtos.CustomerDto;
import tn.iteam.entities.Customer;
import tn.iteam.exceptions.CustomersAlreadyExistsException;
import tn.iteam.exceptions.CustomersNotFoundException;
import tn.iteam.mappers.CustomerMapper;
import tn.iteam.repos.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if(customers.isEmpty())
            throw new CustomersNotFoundException("Customer", "list", "No customers found");
        return customers;
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        // Convertion vers Customer
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        // tester si le customer existe ou non via mobileNumber
        Optional<Customer> optionalCustomer =
                customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent())
            throw new CustomersAlreadyExistsException
                    ("Customer", "mobileNumber",customerDto.getMobileNumber() );

        customerRepository.save(customer);
    }

    @Override
    public CustomerDto findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomersNotFoundException("Customer", "customerId", id.toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        return customerDto;
    }

    @Override
    public CustomerDto findCustomerByMobile(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new CustomersNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        return customerDto;
    }
}
