package tn.iteam.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String environment;
}
