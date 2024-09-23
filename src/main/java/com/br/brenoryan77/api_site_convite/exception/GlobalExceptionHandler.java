package com.br.brenoryan77.api_site_convite.exception;

import com.br.brenoryan77.api_site_convite.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(ServiceException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
