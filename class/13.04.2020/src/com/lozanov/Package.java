package com.lozanov;

public class Package {
    private Payload payload;

    public Package() {

    }

    public Package(Payload payload) {
        this.payload = payload;
    }

    public String serialize() {
        return payload.serialize();
    }

    public String deserialize(String data) {
        
    }
}
