package com.kt.sym.cart.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Cart calculation simulation has failed", e);
        return new ErrorResponse().addError("Cart calculation simulation has failed")
                .getResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static class ErrorResponse {

        private HttpStatus status;
        private final List<String> messages = new ArrayList<>();

        public ErrorResponse addError(String error) {
            messages.add(error);
            return this;
        }

        public ResponseEntity<ErrorResponse> getResponse(HttpStatus status) {
            this.status = status;
            return new ResponseEntity(this, status);
        }

        public HttpStatus getStatus() {
            return status;
        }

        public List<String> getMessages() {
            return messages;
        }

    }
}
