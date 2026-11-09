package tn.iteam.bridges;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iteam.models.Customer;

@FeignClient(name = "CUSTOMER-SERVICE")//The Ms Account Discover the Ms Customer in Eureka
public interface CustomerOpenFeignClients {
    @GetMapping("/customers/{customerId}")
Customer findCustomerById(@PathVariable Long customerId);
}
