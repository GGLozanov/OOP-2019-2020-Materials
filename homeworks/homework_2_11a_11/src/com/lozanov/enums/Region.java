package com.lozanov.enums;

public enum Region {
    SOFIA, BURGAS, VARNA, PLOVDIV, RUSE, GABROVO, VIDIN, VRATSA;

    Integer number = 1000;

    public Integer getNumber() {
        return number++;
    }

    public String getPrefix() {
        switch(this) { // Hey, this would've been better with a hashmap in terms of scalability!
            case SOFIA:
                return "CB";
            case BURGAS:
                return "A";
            case VARNA:
                return "B";
            case PLOVDIV:
                return "PB";
            case RUSE:
                return "P";
            case GABROVO:
                return "EB";
            case VIDIN:
                return "BH";
            case VRATSA:
                return "BP";
            default: return "CB";
        } // Shush! That'd been too much effort for this homework
    }
}
