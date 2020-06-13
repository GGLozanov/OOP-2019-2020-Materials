package test;

import main.animals.Cat;
import main.streams.StreamHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    Cat cat;
    StreamHandler streamHandler;

    @Test
    void walk() {
        cat = new Cat();
        streamHandler = new StreamHandler();
        cat.walk();
        String output = "I am a cat and I am walking";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @Test
    void birth() {
        cat = new Cat();
        streamHandler = new StreamHandler();
        cat.birth();
        String output = "I am a cat and I am giving birth";
        assertEquals(output, streamHandler.getOutContent().toString());
    }

    @Test
    void swim() {
        cat = new Cat();
        streamHandler = new StreamHandler();
        cat.swim();
        String output = "I am a cat and I am swimming; my name is Default";
        assertEquals(output, streamHandler.getOutContent().toString());
    }
}