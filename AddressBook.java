import java.util.*;
public class AddressBook{
	
	public static Map<String,AddressBook> addressBookMap;
	
	public AddressBookMain() {
		addressBookMap = new HashMap<>();
	}
	
	public void addAddressBook(String city) {
		AddressBook addBook = new AddressBook(city);
		addressBookMap.put(city,addBook);
	}
	
	public List<Contact> Book = new ArrayList<Contact>();	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AddressBookMain addBookMain = new AddressBookMain();
		
		int option;
		while(true) {
			System.out.println("Press the given number to perform the operation");
			System.out.println("1. Create addbook");
			System.out.println("2. Add person");
			System.out.println("3. Edit contact");
			System.out.println("4. Delete contact");
			System.out.println("5. View Addressbook");
			System.out.println("6. Exit");
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:
					System.out.println("Enter name of the city to create addressBook");
					String City = sc.nextLine();
					addBookMain.addAddressBook(City);
					break;
				case 2:  
					System.out.println("Enter the person details");
					System.out.println("Enter the first name");
					String first_name = sc.nextLine();
					System.out.println("Enter the last name");
					String last_name = sc.nextLine();
					System.out.println("Enter the address");
					String address = sc.nextLine();
					System.out.println("Enter the city name");
					String city = sc.nextLine();
					System.out.println("Enter the state name");
					String state = sc.next();
					System.out.println("Enter the ZIP code");
					String zip = sc.next();
					System.out.println("Enter the phone number");
					long phone_number = sc.nextLong();
					sc.nextLine();
					System.out.println("Enter the email");
					String email = sc.nextLine();
					Contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
					
					for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {   
						if(entry.getKey().equalsIgnoreCase(city)) {
							entry.getValue().addContact(c);
						}
						else {
							System.out.println("For this city Address Book does not exist");
						}
					}
					break;
				case 3:
					System.out.println("Enter the name to edit contact");
					String x = sc.nextLine();
					System.out.println("Enter the city");
					String city2 = sc.nextLine();
					for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {   
						if(entry.getKey().equalsIgnoreCase(city2)) {
							entry.getValue().editContact(x);
						}
					}
					break;
				case 4:
					System.out.println("Enter the name to delete contact");
					String y = sc.nextLine();
					System.out.println("Enter the city");
					String city1 = sc.nextLine();
					for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {   
						if(entry.getKey().equalsIgnoreCase(city1)) {
							entry.getValue().deleteContact(y);
						}
					}
					break;
				case 5:
					for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
						System.out.println("The addressbook for city "+ entry.getKey() + " :");
						entry.getValue().viewList();
					}
					break;
				case 6:
					System.exit(0);
					break;
			}
		}
	}
}