package tn.iteam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import tn.iteam.dtos.ErrorResponseDto;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    /********AccountsNotFoundException********/
    @ExceptionHandler(AccountsNotFoundException.class)
    public ResponseEntity<ErrorResponseDto>
    handleAccountsNotFoundException(AccountsNotFoundException exception,
                                     WebRequest request  ) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setApiPath(request.getDescription(false));
        errorResponseDto.setErrorCode(HttpStatus.NOT_FOUND);
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

}
