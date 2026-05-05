package org.yourapp.shared.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yourapp.user.exception.UserNotFoundException;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(
            UserNotFoundException e,
            HttpServletRequest request
    ) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        // default fields
        problemDetail.setType(URI.create("https://api.myapp.com/errors/user-not-found"));
        problemDetail.setTitle(e.getErrorCode().getTitle());
        problemDetail.setDetail(e.getDetailMessage());
        problemDetail.setInstance(URI.create(request.getRequestURI()));

        // custom fields
        problemDetail.setProperty("errorCode", e.getErrorCode().getCode());
        problemDetail.setProperty("traceId", "1234567890");
        problemDetail.setProperty("timestamp", Instant.now().toString());

        return problemDetail;
    }
}
