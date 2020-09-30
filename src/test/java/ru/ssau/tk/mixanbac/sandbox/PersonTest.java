package ru.ssau.tk.mixanbac.sandbox;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PersonTest {
    private final Person firstPerson = new Person();
    private final Person secondPerson = new Person();
    private final Person thirdPerson = new Person();
    @Test
    public void testFirstName() {
        assertNull(firstPerson.getFirstName(), null);
        assertNotEquals(firstPerson.getFirstName(), "");
        firstPerson.setFirstName("");
        assertEquals(firstPerson.getFirstName(), "");
        firstPerson.setFirstName("Mixan");
        assertEquals(firstPerson.getFirstName(), "Mixan");
    }
    @Test
    public void testLastName() {
        assertNull(secondPerson.getLastName(), null);
        assertNotEquals(secondPerson.getLastName(), "");
        secondPerson.setLastName("");
        assertEquals(secondPerson.getLastName(), "");
        secondPerson.setLastName("Elena");
        assertNotEquals(secondPerson.getLastName(), "Ivanova");
    }

    @Test
    public void testPassportID() {
        assertEquals(thirdPerson.getPassportId(), 0);
        thirdPerson.setPassportId(953023);
        assertEquals(thirdPerson.getPassportId(),953023);
        assertNotEquals(thirdPerson.getPassportId(),859423);
    }

    @Test
    public void testNameConstructor() {
        Person firstPerson = new Person();
        Person secondPerson = new Person(null, null);

        assertEquals(firstPerson.getFirstName(), null);
        assertEquals(firstPerson.getLastName(), null);
        assertNull(secondPerson.getFirstName());
        assertNull(secondPerson.getLastName());
    }

    @Test
    public void testPassportIdConstructor () {
        Person person = new Person(555);
        assertEquals(person.getPassportId(), 555);
        assertNotEquals(person.getPassportId(), 777);
    }

    @Test
    public void testFullConstructor () {
        Person firstPerson = new Person("Vlada", "Petrova", 953023);
        Person secondPerson = new Person(null, null, 839393);

        assertEquals(firstPerson.getFirstName(), "Vlada");
        assertEquals(firstPerson.getLastName(), "Petrova");
        assertEquals(firstPerson.getPassportId(), 953023);
        assertNull(secondPerson.getFirstName());
        assertNull(secondPerson.getLastName());
    }
}





