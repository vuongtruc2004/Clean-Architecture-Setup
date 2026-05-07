package org.yourapp.shared.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ProblemDetailRequest(
        HttpStatus status,
        ErrorCode errorCode,
        String type,
        String detail,
        String instance
) {
}
