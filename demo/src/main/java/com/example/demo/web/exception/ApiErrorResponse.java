package com.example.demo.web.exception;

import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ApiErrorResponse {
    int status;
    String error;
    String message;
    String path;
    List<FieldErrorDetail> details;

    @Value
    @Builder
    public static class FieldErrorDetail {
        String field;
        String reason;
    }
}
