package tn.iteam.services;

import tn.iteam.dtos.CustomerDto;
import tn.iteam.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    void saveCustomer(CustomerDto customerDto);
    CustomerDto findCustomerById(Long id);
    CustomerDto findCustomerByMobile(String mobile);
}

