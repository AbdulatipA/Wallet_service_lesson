package org.example.wallet_service_lesson.exceptions;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
