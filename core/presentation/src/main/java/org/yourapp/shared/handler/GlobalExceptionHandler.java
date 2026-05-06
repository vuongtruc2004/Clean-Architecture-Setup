package org.yourapp.shared.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yourapp.shared.exception.ApplicationException;
import org.yourapp.shared.exception.ErrorCode;
import org.yourapp.shared.exception.ProblemDetailProperties;
import org.yourapp.shared.logging.LoggingKeys;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ProblemDetail handleApplicationException(
            ApplicationException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorCode errorCode = e.getErrorCode();

        // Create ProblemDetail
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        // default fields
        problemDetail.setType(URI.create("https://api.myapp.com/errors/user-not-found"));
        problemDetail.setTitle(errorCode.getTitle());
        problemDetail.setDetail(e.getMessage());
        problemDetail.setInstance(URI.create(request.getRequestURI()));

        // custom fields
        problemDetail.setProperty(ProblemDetailProperties.ERROR_CODE, errorCode.getCode());
        problemDetail.setProperty(ProblemDetailProperties.TRACE_ID, "1234567890");
        problemDetail.setProperty(ProblemDetailProperties.TIMESTAMP, Instant.now().toString());

        // Config logging
        ThreadContext.put(LoggingKeys.HTTP_STATUS_CODE, String.valueOf(status.value()));

        ThreadContext.put(LoggingKeys.ERROR_CODE, errorCode.getCode());
        ThreadContext.put(LoggingKeys.ERROR_MESSAGE, e.getMessage());
        ThreadContext.put(LoggingKeys.ERROR_TYPE, e.getClass().getSimpleName());

        log.warn(errorCode.getTitle(), e);
        return problemDetail;
    }
}
