package com.example.demobff.infrastructure.config;

import com.example.demobff.domain.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTests {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleGlobalException_ReturnsInternalServerError() {
        Exception exception = new Exception("Global error");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<?> response = globalExceptionHandler.handleGlobalException(exception, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Global error", response.getBody());
    }

    @Test
    void handleEntityNotFoundException_ReturnsNotFound() {
        EntityNotFoundException exception = new EntityNotFoundException("Entity not found");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<?> response = globalExceptionHandler.handleEntityNotFoundException(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Entity not found", response.getBody());
    }

    @Test
    void handleRestClientException_ReturnsInternalServerError() {
        RestClientException exception = new RestClientException("Rest client error");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<?> response = globalExceptionHandler.handleRestClientException(exception, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Rest client error", response.getBody());
    }
}