package com.oraiche.pneus.exceptions;

public class PneuNotFoundException extends RuntimeException{
    public PneuNotFoundException(String message) {
        super(message);
    }
}
