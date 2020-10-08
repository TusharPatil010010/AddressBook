import java.util.*;
public class AddressBook{
	
	public static Map<String, NewAddressBook> addressBookMap;
	
	public AddressBook() {
		addressBookMap = new HashMap<>();
	}
	
	public void addAddressBook(String city) {
		NewAddressBook addBook = new NewAddressBook(city);
		addressBookMap.put(city, addBook);
	}
	
	public void searchPersonByCity(String name, String city) {
		List<person> list = new ArrayList<person>();
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(p -> p.getCity().equals(city))
					.filter(p -> (p.getFirstName() + " " + p.getLastName())
					.equals(name)).collect(Collectors.toList());
		}
		for(person p : list) {
			System.out.println(p);
		}
	}	

	public void searchPersonByState(String name, String state) {
		List<person> list = new ArrayList<person>();
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(p -> p.getState().equals(state))
					.filter(p -> (p.getFirstName() + " " + p.getLastName())
					.equals(name)).collect(Collectors.toList());
		}
		for(person p : list) {
			System.out.println(p);
		}
	}

	public void viewDataByCity(String city) {
		List<Contact> list = new ArrayList<Contact>();
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(p -> p.getState().equals(city))
					.collect(Collectors.toList());
		}
		for(Contact p : list) {
			System.out.println(p);
		}
	}
	public void viewDataByState(String state) {
		List<Contact> list = new ArrayList<Contact>();
		for(Map.Entry<String ,NewAddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(p -> p.getState().equals(state))
					.collect(Collectors.toList());
		}
		for(Contact p : list) {
			System.out.println(p);
		}
	}

	public void countByCity(String city) {
		long count = 0;
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			count = entry.getValue().getBook().stream().filter(p -> p.getCity().equals(city))
					.count();
		}
		System.out.println("count is "+count);
	}
	public void countByState(String state) {
		long count = 0;
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			count = entry.getValue().getBook().stream().filter(p -> p.getState().equals(state))
					.count();
		}
		System.out.println("count is "+count);
	}
	
	public void sortByName() {
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			Collections.sort(entry.getValue().getBook(),new SortByName());
		}

	}

	public void sortByZip() {
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			Collections.sort(entry.getValue().getBook(),new SortByZip());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AddressBook addBookMain = new AddressBook();
		
		int option;
		while(true) {
			System.out.println("Press the given number to perform the operation");
			System.out.println("1. Create addbook");
			System.out.println("2. Add person");
			System.out.println("3. Edit contact");
			System.out.println("4. Delete contact");
			System.out.println("5. View Addressbook");
			System.out.println("6. Search From City");
			System.out.println("7. Search From State");
			System.out.println("8. View data by city");
			System.out.println("9. View data in state");
			System.out.println("10. Count contact from city");
			System.out.println("11. Count contact from state");
			System.out.println("12. Sort the addressbook by name");
			System.out.println("13. Sort the addressbook by ZIP");
			System.out.println("14. exit");
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
					person = new person(firstName, lastName, address, city, state, zip, phoneNumber, email);
					
					for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {   
						if(entry.getKey().equalsIgnoreCase(city)) {
							entry.getValue().addPerson(p);
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
							entry.getValue().editPerson(x);
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
							entry.getValue().deletePerson(y);
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
					System.out.println("Enter the name to search");
					String searchName = scanner.nextLine();
					System.out.println("Enter the city");
					String cityName = scanner.nextLine();
					addBookMain.searchPersonByCity(searchName, cityName);
					break;
				case 7:
					System.out.println("Enter the name to search");
					String personName = scanner.nextLine();
					System.out.println("Enter the state");
					String stateName = scanner.nextLine();
					addBookMain.searchPersonByCity(personName, stateName);
					break;
				case 8:
					System.out.println("Enter the city");
					String cityData = scanner.nextLine();
					addBookMain.viewDataByCity(cityData);
					break;
				case 9:
					System.out.println("Enter the state");
					String stateData = scanner.nextLine();
					addBookMain.viewDataByState(statData);
					break;
				case 10:
					System.out.println("Enter the city");
					String cityCount = scanner.nextLine();
					addBookMain.countByCity(cityCount);
					break;
				case 11:
					System.out.println("Enter the city");
					String stateCount = scanner.nextLine();
					addBookMain.countByState(stateCount);
					break;
				case 12:
					addBookMain.sortByName();
					break;
				case 13:
					addBookMain.sortByZ();
					break;
				case 14:
					System.exit(0);
			}
		}
	}
}