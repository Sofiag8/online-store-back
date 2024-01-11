package com.example.onlinestoreback.ErrorHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiErrorResponse> handleApiNotFoundResourceException(
    ResourceNotFoundException ex) {
      ApiErrorResponse response = 
        new ApiErrorResponse("error-0001",
            "Resource not found with ID " + ex.getId());
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiErrorResponse> handleApiNotFoundException(
    NotFoundException ex) {
      ApiErrorResponse response = 
        new ApiErrorResponse("error-0002",
            "Resources not found " + ex.getMessage());
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiErrorResponse> handleApiValidationException(
    MethodArgumentNotValidException ex
  ) {

    List<FieldError> errors = ex.getFieldErrors();
    Map<String, Object> body = new LinkedHashMap<>();

    for (FieldError error : errors ) {
      body.put(error.getField(), error.getDefaultMessage());
    } 

    ApiErrorResponse response = 
      new ApiErrorResponse("Validation error", "Bad request: " + body);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

  }
}
