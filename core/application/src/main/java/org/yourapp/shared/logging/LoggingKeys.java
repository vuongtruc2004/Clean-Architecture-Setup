package org.yourapp.shared.logging;

public final class LoggingKeys {
    private LoggingKeys() {
    }

    public static final String TRACE_ID = "traceId";
    public static final String USER_ID = "userId";
    public static final String USER_ROLE = "userRole";

    public static final String HTTP_ROUTE = "httpRoute";
    public static final String HTTP_METHOD = "httpMethod";
    public static final String HTTP_CLIENT_IP = "httpClientIp";
    public static final String HTTP_DURATION_MS = "httpDurationMs";
    public static final String HTTP_STATUS_CODE = "httpStatusCode";

    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String ERROR_TYPE = "errorType";
    public static final String ERROR_STACKTRACE = "errorStackTrace";
}
