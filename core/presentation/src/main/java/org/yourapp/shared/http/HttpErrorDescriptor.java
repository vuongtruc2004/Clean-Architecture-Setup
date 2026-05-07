package org.yourapp.shared.http;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record HttpErrorDescriptor(
        HttpStatus status,
        String type
) {
}
