package com.lego.omer.error;

public class LegoCharacterNotFoundException extends RuntimeException {

    public LegoCharacterNotFoundException(String message) {
        super(message);
    }
}
