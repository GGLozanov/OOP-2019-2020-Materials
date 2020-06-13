package com.company;

public class Main {

    public static void main(String[] args) {
        // StringPool - way Java optimises and works through Strings
        // if we already have a recorded String in the StringPool (by initialising a String with just its value)
        // it'll be retained and its value will be retained later from the pool with similar initialisations
        // this does NOT apply to instantiations of object String
        // (because the comparing of references doesn't work across objects and the string isn't accessed from the StringPool)
        String hello = "Hello";
        String hello2 = new String("Hello");
        System.out.println(hello == hello2);
        // write your code here
    }
}
