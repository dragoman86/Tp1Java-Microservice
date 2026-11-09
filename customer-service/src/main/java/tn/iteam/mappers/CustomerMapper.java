package tn.iteam.mappers;

import tn.iteam.dtos.CustomerDto;
import tn.iteam.entities.Customer;

public class CustomerMapper {

    // from Customer ----> CustomerDto
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setEnvironment(customer.getEnvironment());

        return customerDto;
    }
    // from CustomerDto ----> Customer
    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setEnvironment(customerDto.getEnvironment());

        return customer;
    }
}
