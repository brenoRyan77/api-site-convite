package com.br.brenoryan77.api_site_convite.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(HttpStatus status, String message, WebRequest request) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.path = request.getDescription(false).replace("uri=", "");
    }
}
