package com.lozanov;

public class Payload <T> {
    T data;

    public Payload() {

    }

    public Payload(T data) {
        this.data = data;
    }

    public String serialize() {
        return data.toString();
    }
}
