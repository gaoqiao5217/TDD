import java.util.HashMap;
import java.util.TreeSet;

public class PhoneBook {
    private HashMap<String, String> contactsByNumber;
    private HashMap<String, String> contactsByName;

    public PhoneBook() {
        contactsByName = new HashMap<>();
        contactsByNumber = new HashMap<>();
    }

    public int add(String name, String number) {
        if (!contactsByName.containsKey(name) && !contactsByNumber.containsKey(number)) {
            contactsByNumber.put(number, name);
            contactsByName.put(name, number);
        }
        return contactsByNumber.size();
    }

    public String findByNumber(String number) {
        return contactsByNumber.get(number);
    }

    public String findByName(String name){
        return contactsByName.get(name);
    }

    public void printAllNames() {
        new TreeSet<>(contactsByName.keySet()).forEach(System.out::println);
    }
}