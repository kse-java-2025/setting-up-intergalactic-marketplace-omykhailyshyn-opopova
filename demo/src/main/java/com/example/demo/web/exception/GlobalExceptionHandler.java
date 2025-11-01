package com.example.demo.web.exception;

import com.example.demo.service.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleProductNotFound(ProductNotFoundException ex, HttpServletRequest request) {
        ApiErrorResponse resp = ApiErrorResponse.builder()
                .type("/errors/not-found")
                .title("Product not found")
                .status(HttpStatus.NOT_FOUND.value())
                .detail("The product with ID " + ex.getMessage() + " could not be found.")
                .instance(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationError(ValidationException ex, HttpServletRequest request) {
        ApiErrorResponse resp = ApiErrorResponse.builder()
                .type("about:blank")
                .title("Bad Request")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail(ex.getMessage())
                .instance(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ApiErrorResponse> handleInternalServerError(InternalServerErrorException ex, HttpServletRequest request) {
        ApiErrorResponse resp = ApiErrorResponse.builder()
                .type("/errors/internal-server-error")
                .title("Internal Server Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail("An unexpected error occurred on the server.")
                .instance(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {
        String field = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(err -> String.format("Field '%s' %s", err.getField(), err.getDefaultMessage()))
                .orElse("Validation failed");

        ApiErrorResponse resp = ApiErrorResponse.builder()
                .type("about:blank")
                .title("Bad Request")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail(field)
                .instance(request.getDescription(false).replace("uri=", ""))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }
}
