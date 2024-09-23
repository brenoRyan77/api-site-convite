package com.br.brenoryan77.api_site_convite.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
