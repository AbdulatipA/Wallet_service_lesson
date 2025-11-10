package org.example.wallet_service_lesson.exceptions;


public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
