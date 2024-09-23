import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}