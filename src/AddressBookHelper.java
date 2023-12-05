import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class AddressBookHelper {
    private Map<String, AddressBook> addressBooks;
    private Scanner scanner;

    public AddressBookHelper() {
        this.addressBooks = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addAddressBook(String addressBookName) {
        AddressBook newAddressBook = new AddressBook(addressBookName);
        addressBooks.put(addressBookName, newAddressBook);
        System.out.println("Address Book '" + addressBookName + "' created successfully.");
    }

    public AddressBook accessAddressBook(String addressBookName) {
        return addressBooks.get(addressBookName);
    }

    public void viewAllAddressBooks() {
        System.out.println("Available Address Books:");
        for (String addressBookName : addressBooks.keySet()) {
            System.out.println(addressBookName);
        }
    }

    public void searchContactsByCity(String city) {
        for (AddressBook addressBook : addressBooks.values()) {
            System.out.println("Contacts in " + addressBook.getName() + " with city " + city + ":");
            addressBook.searchByCityOrState(city).forEach(System.out::println);
        }
    }

    public void searchContactsByState(String state) {
        for (AddressBook addressBook : addressBooks.values()) {
            System.out.println("Contacts in " + addressBook.getName() + " with state " + state + ":");
            addressBook.searchByCityOrState(state).forEach(System.out::println);
        }
    }

    public void countContactsByCity(String city) {
        int totalCount = 0;
        for (AddressBook addressBook : addressBooks.values()) {
            int count = addressBook.countContactsByCityOrState(city);
            System.out.println("Contacts in " + addressBook.getName() + " with city " + city + ": " + count);
            totalCount += count;
        }
        System.out.println("Total count across all Address Books: " + totalCount);
    }

    public void countContactsByState(String state) {
        int totalCount = 0;
        for (AddressBook addressBook : addressBooks.values()) {
            int count = addressBook.countContactsByCityOrState(state);
            System.out.println("Contacts in " + addressBook.getName() + " with state " + state + ": " + count);
            totalCount += count;
        }
        System.out.println("Total count across all Address Books: " + totalCount);
    }

    public void sortAddressBook(AddressBook addressBook) {
        System.out.println("Choose field to sort by: ");
        System.out.println("1. Name");
        System.out.println("2. City");
        System.out.println("3. State");
        System.out.println("4. Zip");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addressBook.sortByName();
                break;
            case 2:
                addressBook.sortByCity();
                break;
            case 3:
                addressBook.sortByState();
                break;
            case 4:
                addressBook.sortByZip();
                break;
            default:
                System.out.println("Invalid choice");
        }
        addressBook.displayContacts();
    }
}
