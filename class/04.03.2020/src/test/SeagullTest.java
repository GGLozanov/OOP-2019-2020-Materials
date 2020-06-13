package test;

import main.animals.Seagull;
import main.streams.StreamHandler;

import static org.junit.jupiter.api.Assertions.*;

class SeagullTest {

    Seagull seagull;
    StreamHandler streamHandler;

    @org.junit.jupiter.api.Test
    void sayName() {
        seagull = new Seagull();
        streamHandler = new StreamHandler();
        seagull.sayName();
        String output = "I am a Seagull and my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @org.junit.jupiter.api.Test
    void fly() {
        seagull = new Seagull();
        streamHandler = new StreamHandler();
        seagull.fly();
        String output = "I am a Seagull; I am flying and my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @org.junit.jupiter.api.Test
    void birth() {
        seagull = new Seagull();
        streamHandler = new StreamHandler();
        seagull.birth();
        String output = "I am a whale and I am giving birth; and my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @org.junit.jupiter.api.Test
    void swim() {
        seagull = new Seagull();
        streamHandler = new StreamHandler();
        seagull.swim();
        String output = "I am a Seagull I am giving birth; my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @org.junit.jupiter.api.Test
    void walk() {
        seagull = new Seagull();
        streamHandler = new StreamHandler();
        seagull.walk();
        String output = "I am a Seagull and I am walking; my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }
}