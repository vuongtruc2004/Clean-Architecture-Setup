package org.yourapp.shared.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yourapp.shared.exception.*;
import org.yourapp.shared.logging.ExceptionLoggingContext;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    private final ProblemDetailFactory problemDetailFactory;
    private final ExceptionLoggingContext exceptionLoggingContext;

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(
            NotFoundException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorCode errorCode = e.getErrorCode();

        ProblemDetail problemDetail = problemDetailFactory.create(
                ProblemDetailRequest.builder()
                        .status(status)
                        .errorCode(errorCode)
                        .type("https://api.myapp.com/errors/user-not-found")
                        .detail(e.getMessage())
                        .instance(request.getRequestURI())
                        .build()
        );

        exceptionLoggingContext.putApplicationException(status, e);
        log.warn(errorCode.getTitle(), e);
        return problemDetail;
    }

    @ExceptionHandler(InvalidCommandException.class)
    public ProblemDetail handleInvalidCommandException(
            InvalidCommandException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorCode errorCode = e.getErrorCode();

        ProblemDetail problemDetail = problemDetailFactory.create(
                ProblemDetailRequest.builder()
                        .status(status)
                        .errorCode(errorCode)
                        .type("https://api.myapp.com/errors/invalid-command")
                        .detail(e.getMessage())
                        .instance(request.getRequestURI())
                        .build()
        );

        exceptionLoggingContext.putApplicationException(status, e);
        log.warn(errorCode.getTitle(), e);
        return problemDetail;
    }
}
