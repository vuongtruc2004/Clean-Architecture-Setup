package org.yourapp.shared.http;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.yourapp.shared.exception.CommandErrorCode;
import org.yourapp.shared.exception.ErrorCode;
import org.yourapp.user.exception.UserApplicationErrorCode;

@Component
public class ErrorCodeHttpMapper {
    private static final String ERROR_TYPE_BASE = "https://api.myapp.com/errors/";

    public HttpErrorDescriptor toHttpErrorDescriptor(ErrorCode errorCode) {
        return switch (errorCode) {
            case UserApplicationErrorCode.USER_NOT_FOUND -> HttpErrorDescriptor.builder()
                    .status(HttpStatus.NOT_FOUND)
                    .type(ERROR_TYPE_BASE + "user-not-found")
                    .build();

            case CommandErrorCode.REQUIRED_FIELD_MISSING -> HttpErrorDescriptor.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .type(ERROR_TYPE_BASE + "required-field-missing")
                    .build();

            case CommandErrorCode.EMPTY_LIST -> HttpErrorDescriptor.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .type(ERROR_TYPE_BASE + "empty-list")
                    .build();
            
            default -> HttpErrorDescriptor.builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .type(ERROR_TYPE_BASE + "internal-server-error")
                    .build();
        };
    }
}
