package tn.iteam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountsNotFoundException extends RuntimeException{
    public AccountsNotFoundException(String ressName, String fieldName, String fieldValue) {
        super(String.format("%s not found for field %s and value %s", ressName, fieldName, fieldValue));
    }
}