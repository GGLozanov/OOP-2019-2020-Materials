package com.lozanov.exceptions;

public class NoFurnaceException extends Exception {
    public NoFurnaceException(String message) {
        super(message);
    }

    public NoFurnaceException() {
        super();
    }
}