package org.yourapp.shared.handler;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.ThreadContext;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.yourapp.shared.annotation.ApiResponseMessage;
import org.yourapp.shared.logging.ContextLoggingKeys;
import org.yourapp.shared.response.ApiMeta;
import org.yourapp.shared.response.ApiResponse;
import org.yourapp.shared.response.PageMeta;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // nếu controller đã trả ra ApiResponse rồi thì không bọc nữa
        if (ApiResponse.class.isAssignableFrom(returnType.getParameterType())) {
            return false;
        }
        if (ProblemDetail.class.isAssignableFrom(returnType.getParameterType())) {
            return false;
        }
        return true;
    }

    @Override
    public @Nullable Object beforeBodyWrite(
            @Nullable Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response
    ) {
        if (body == null ||
                body instanceof ApiResponse<?> ||
                body instanceof ProblemDetail) {
            return body;
        }

        ApiResponseMessage apiResponseMessage = returnType.getMethodAnnotation(ApiResponseMessage.class);
        String message = apiResponseMessage == null ? "No message" : apiResponseMessage.message();

        if (body instanceof Page<?> page) {
            return ApiResponse.builder()
                    .meta(ApiMeta.createWithPagination(
                            ThreadContext.get(ContextLoggingKeys.TRACE_ID),
                            PageMeta.fromPage(page)
                    ))
                    .message(message)
                    .data(page.getContent())
                    .build();
        }
        return ApiResponse.builder()
                .meta(ApiMeta.create(ThreadContext.get(ContextLoggingKeys.TRACE_ID)))
                .message(message)
                .data(body)
                .build();
    }
}
