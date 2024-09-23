import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, String> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public int add(String name, String number) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, number);
        }
        return contacts.size();
    }

    public String findByNumber(String number) {
        return null;
    }
}