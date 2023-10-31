package ru.gilev.city.exception;

import lombok.Data;

@Data
public class CitizenCustomException extends RuntimeException{
    String errorCode;

    public CitizenCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
