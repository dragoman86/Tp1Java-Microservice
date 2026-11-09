package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Customer;
import tn.iteam.repos.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
        System.out.println("MS CUSTOMER STARTED SUCCEFULLY!!");
    }
//Initial DATA
    @Bean
    public CommandLineRunner initData(CustomerRepository repository) {
        return args -> {
            //Begin Transaction
            Customer customer1 = Customer.builder()
                    .firstName("Walid")
                    .lastName("Benna")
                    .mobileNumber("123456789")
                    .email("walid@gmail.com")
                    .build();
            repository.save(customer1);
            Customer customer2 = Customer.builder()
                    .firstName("Hassen")
                    .lastName("Belazrak")
                    .mobileNumber("21545875")
                    .email("hassen@voila.fr")
                    .build();
            repository.save(customer2);
            //End Transcation
        };
    }
}
