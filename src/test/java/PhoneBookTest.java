import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void addContactTest(){
        phoneBook = new PhoneBook();
        for (int i = 0; i < 10; i++) {
            int count = phoneBook.add("Name " + i + 1, "Number " + i + 1);
            assertEquals(i+1, count, "Contact count should be "
                    + (i+1) + " after adding a contact " + i);
        }
    }

    @Test
    public void findByNumberTest(){
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");

        String foundName = phoneBook.findByNumber("12345");
        assertEquals("Alice", foundName, "Should find Alice by number 12345");

        foundName = phoneBook.findByNumber("67890");
        assertEquals("Bob", foundName, "Should find Bob by number 67890");

        foundName = phoneBook.findByNumber("11111");
        assertNull(foundName, "Should return null for non-existing number");
    }

    @Test
    public void findByNameTest() {
        String name = "Alice";
        String number = "12345";

        phoneBook.add(name, number);

        String foundNumber = phoneBook.findByName(name);
        assertEquals(number, foundNumber, "Should find the correct number for Alice");

        foundNumber = phoneBook.findByName("Bob");
        assertNull(foundNumber, "Should return null for non-existing name");
    }

    @Test
    public void testPrintAllNames() {
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneBook.printAllNames();
        System.setOut(originalOut);
        String expectedOutput = "Alice\nBob" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}