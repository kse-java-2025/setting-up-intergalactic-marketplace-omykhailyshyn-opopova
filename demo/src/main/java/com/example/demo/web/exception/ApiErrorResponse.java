package com.example.demo.web.exception;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ApiErrorResponse {
    String type;     
    String title;
    int status;
    String detail;
    String instance;
}
