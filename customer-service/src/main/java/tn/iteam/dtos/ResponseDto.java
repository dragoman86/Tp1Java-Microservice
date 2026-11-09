package tn.iteam.dtos;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class ResponseDto {
    private String statusCode;
    private String statusMessage;
}
