package org.yourapp.shared.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.time.Instant;

@Component
public class ProblemDetailFactory {
    public ProblemDetail create(ProblemDetailRequest problemDetailRequest) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(problemDetailRequest.status());
        // set default fields
        problemDetail.setType(URI.create(problemDetailRequest.type()));
        problemDetail.setTitle(problemDetailRequest.errorCode().getTitle());
        problemDetail.setDetail(problemDetailRequest.detail());
        problemDetail.setInstance(URI.create(problemDetailRequest.instance()));

        // set custom fields
        problemDetail.setProperty(ProblemDetailProperties.ERROR_CODE, problemDetailRequest.errorCode().getCode());
        problemDetail.setProperty(ProblemDetailProperties.TRACE_ID, "1234567890");
        problemDetail.setProperty(ProblemDetailProperties.TIMESTAMP, Instant.now().toString());
        return problemDetail;
    }
}
