package tn.iteam.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.entities.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Recherche par mobile Number

    Optional<Customer> findByMobileNumber(String mobileNumber);
}
