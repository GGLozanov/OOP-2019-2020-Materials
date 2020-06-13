package com.lozanov.exceptions;

public class NoPizzaioloException extends Exception {
    public NoPizzaioloException(String message) {
        super(message);
    }

    public NoPizzaioloException() {
        super();
    }
}