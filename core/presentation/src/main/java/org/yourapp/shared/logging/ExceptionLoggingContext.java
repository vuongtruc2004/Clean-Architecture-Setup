package org.yourapp.shared.logging;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.yourapp.shared.exception.ApplicationException;

@Component
public class ExceptionLoggingContext {

    public void putApplicationException(HttpStatus status, ApplicationException e) {
        ThreadContext.put(HttpLoggingKeys.HTTP_STATUS_CODE, String.valueOf(status.value()));

        ThreadContext.put(ErrorLoggingKeys.ERROR_CODE, e.getErrorCode().getCode());
        ThreadContext.put(ErrorLoggingKeys.ERROR_MESSAGE, e.getMessage());
        ThreadContext.put(ErrorLoggingKeys.ERROR_TYPE, e.getClass().getSimpleName());
    }
}
