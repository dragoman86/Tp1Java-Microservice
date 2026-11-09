package tn.iteam.dtos;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String environment;
}
