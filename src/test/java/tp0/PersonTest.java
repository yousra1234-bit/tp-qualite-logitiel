package tp0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testGetFullName_NormalCase() {
        Person person = new Person("John", "Doe", 25);
        Assertions.assertEquals("John Doe", person.getFullName());
    }

    @Test
    public void testGetFullName_EmptyFirstName() {
        Person person = new Person("", "sanaa", 22);
        Assertions.assertEquals("Unknown", person.getFullName());
    }

    @Test
    public void testGetFullName_EmptyLastName() {
        Person person = new Person("yousra", "", 22);
        Assertions.assertEquals("Unknown", person.getFullName());
    }

    @Test
    public void testGetFullName_NullFirstName() {
        Person person = new Person(null, "yousra", 22);
        Assertions.assertEquals("Unknown", person.getFullName());
    }

    @Test
    public void testGetFullName_NullLastName() {
        Person person = new Person("rofi", null, 22);
        Assertions.assertEquals("Unknown", person.getFullName());
    }

    @Test
    public void testIsAdult_NormalCase() {
        Person person = new Person("soulef", "talbi", 20);
        Assertions.assertTrue(person.isAdult());
    }

    @Test
    public void testIsAdult_Age17() {
        Person person = new Person("manar", "sebti", 17);
        Assertions.assertFalse(person.isAdult());
    }

    @Test
    public void testIsAdult_Age18() {
        Person person = new Person("fatna", "boussedra", 45);
        Assertions.assertTrue(person.isAdult());
    }

    @Test
    public void testIsAdult_Age100() {
        Person person = new Person("sarah", "fellah", 100);
        Assertions.assertTrue(person.isAdult());
    }
}
