package test;

import main.animals.Whale;
import main.streams.StreamHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhaleTest {

    Whale whale;
    StreamHandler streamHandler;

    @Test
    void sayName() {
        whale = new Whale();
        streamHandler = new StreamHandler();
        whale.sayName();
        String output = "I am a whale and my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @Test
    void walk() {
        whale = new Whale();
        streamHandler = new StreamHandler();
        whale.walk();
        String output = "I am a whale and I cannot walk; and my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @Test
    void birth() {
        whale = new Whale();
        streamHandler = new StreamHandler();
        whale.birth();
        String output = "I am a Seagull I am giving birth; my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @Test
    void swim() {
        whale = new Whale();
        streamHandler = new StreamHandler();
        whale.swim();
        String output = "I am a whale I am swimming; and my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }
}