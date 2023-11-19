package CodeTest;

import Code.Person;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {
    @Test
    void testSetAndGetFirstName() {
        Person person = new ConcretePerson();
        person.setFirstName("John");
        assertEquals("John", person.getFirstName());
    }

    @Test
    void testSetAndGetLastName() {
        Person person = new ConcretePerson();
        person.setLastName("Doe");
        assertEquals("Doe", person.getLastName());
    }

    @Test
    void testSetAndGetDateOfBirth() throws ParseException {
        Person person = new ConcretePerson();
        String dateOfBirth = "2000-01-01";
        person.setDateOfBrith(dateOfBirth);
        assertEquals(dateOfBirth, person.getDateOfBrith());
    }

    @Test
    void testSetAndGetDateOfBirthWithInvalidFormat() {
        Person person = new ConcretePerson();
        assertThrows(ParseException.class, () -> person.setDateOfBrith("invalidDate"));
    }

    @Test
    void testEqualsAndHashCode() throws ParseException {
        Person person1 = new ConcretePerson();
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setDateOfBrith("2000-01-01");

        Person person2 = new ConcretePerson();
        person2.setFirstName("John");
        person2.setLastName("Doe");
        person2.setDateOfBrith("2000-01-01");

        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void testToString() throws ParseException {
        Person person = new ConcretePerson();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setDateOfBrith("2000-01-01");

        String expectedToString = "Person{firstName='John', lastName='Doe', dateOfBrith=Sat Jan 01 00:00:00 MSK 2000}";
        assertEquals(expectedToString, person.toString());
    }

    // ConcretePerson class is created to test the abstract Person class
    private static class ConcretePerson extends Person {
    }
}