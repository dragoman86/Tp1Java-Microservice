package tn.iteam.enums;



import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum AccountRespStatus {

    // CREATED, SUCCESS, BAD_REQUEST, SERVER_ERROR
    CREATED("201", "Account created successfully"),
    SUCCESS("200", "Request processed successfully"),
    BAD_REQUESt("400", "Bad, request, please check your parameters"),
    SERVICE_ERROR("500", "An error occurred while processing the request");


    private final String code;
    private final String message;
}

