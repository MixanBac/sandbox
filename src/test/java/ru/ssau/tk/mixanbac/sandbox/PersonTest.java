package ru.ssau.tk.mixanbac.sandbox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PersonTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testMethods() {
        Person firstPerson = new Person();
        Person secondPerson = new Person();
        firstPerson.setFirstName("Mixan");
        secondPerson.setFirstName("Bac");
        firstPerson.setLastName("Lena");
        secondPerson.setLastName("Sokol");
        firstPerson.setPassportId(774847584);
        secondPerson.setPassportId(734873475);
        assertEquals(firstPerson.getFirstName(), "Mixan");
        assertEquals(secondPerson.getFirstName(), "Bac");
        assertEquals(firstPerson.getLastName(), "Lena");
        assertEquals(secondPerson.getLastName(), "Sokol");
        assertEquals(firstPerson.getPassportId(), 774847584, DELTA);
        assertEquals(secondPerson.getPassportId(), 734873475, DELTA);
    }
}
