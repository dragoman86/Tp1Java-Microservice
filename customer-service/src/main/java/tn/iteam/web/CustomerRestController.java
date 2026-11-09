package tn.iteam.web;

import jakarta.ws.rs.PathParam;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iteam.dtos.CustomerDto;
import tn.iteam.dtos.ResponseDto;
import tn.iteam.entities.Customer;
import tn.iteam.enums.CustomerRespStatus;
import tn.iteam.services.CustomerService;

import java.util.List;

@RestController
public class CustomerRestController {
    // faire appel à la couche service
    /**
     * Injection de dependances
     */
    private final CustomerService customerService;
    private final Environment environment;

    public CustomerRestController(CustomerService customerService, Environment environment) {
        this.customerService = customerService;
        this.environment = environment;
    }
    /**
     * CRUD API creator
     */
    // GET /customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> retreiveAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return ResponseEntity
                .ok(customers);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> retreiveOneCustomer(@PathVariable Long id) {
        CustomerDto customerDto = customerService.findCustomerById(id);
        String port = environment.getProperty("server.port");
        customerDto.setEnvironment(port);
        return ResponseEntity
                .ok(customerDto);
    }

    @GetMapping("/customers/fetch")
    public ResponseEntity<CustomerDto> retreiveOneCustomerM
            (@PathParam(value = "mobileNumber") String mobileNumber) {
        CustomerDto customerDto = customerService.findCustomerByMobile(mobileNumber);
        return ResponseEntity
                .ok(customerDto);
    }

    @PostMapping("/customers")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CustomerRespStatus.CREATED.getCode(),
                        CustomerRespStatus.CREATED.getMessage()));
    }

}
