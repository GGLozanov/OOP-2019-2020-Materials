package org.elsys.glozanov;

import static org.junit.jupiter.api.Assertions.*;

class RapperTest {

    Rapper rapper;

    @org.junit.jupiter.api.BeforeEach // annotation for BeforeEach
    void getName() {
        rapper = new Rapper(); // each test gets a new instance
        assertEquals(rapper.name, rapper.getName());
    }

    @org.junit.jupiter.api.Test
    void getEarnings() {
    }

    @org.junit.jupiter.api.Test
    void incrementCount() {
        assertEquals(Rapper.getCount(), 1);
    }

    @org.junit.jupiter.api.Test
    void getCount() {
    }
}