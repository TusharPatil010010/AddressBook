import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import java.util.Collections;

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
		List<person> list = new ArrayList<person>();
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(p -> p.getState().equals(city))
					.collect(Collectors.toList());
		}
		for(person p : list) {
			System.out.println(p);
		}
	}
	public void viewDataByState(String state) {
		List<person> list = new ArrayList<person>();
		for(Map.Entry<String, NewAddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getBook().stream().filter(p -> p.getState().equals(state))
					.collect(Collectors.toList());
		}
		for(person p : list) {
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
		System.out.println("count is " + count);
	}
	
	public void sortByName() {
		List<person> personList = new ArrayList<>();
		for (Map.Entry<String, AddressBook> entry : StateAddressBookMap.entrySet()) {
			personList = entry.getValue().getPersonList().stream()
					.sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
		}

		System.out.println("Sorted list of names: ");
		for (Person list : personList) {
			System.out.println(list.getName());
		}
	}

	public void sortByZip() {
		List<person> personList = new ArrayList<>();
		for (Map.Entry<String, AddressBook> entry : StateAddressBookMap.entrySet()) {
			personList = entry.getValue().getPersonList().stream()
					.sorted((p1, p2) -> Integer.compare(p1.getZip(), p2.getZip())).collect(Collectors.toList());
		}

		System.out.println("Sorted list of ZIPs : ");
		for (Person list : personList) {
			System.out.println(list.getZip());
		}
	}

	public void writeData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO)) {
			new AddressBookService().writeData(addressBookMap);
		}
	}

	public void readData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO)) {
			new AddressBookService().readData();
		}
	}

	public static void writeContactAsCSV(person contact) 
	{ 
		Path path = Paths.get("addressBook.csv");
		try { 
			FileWriter outputfile = new FileWriter(path.toFile(), true); 
			CSVWriter writer = new CSVWriter(outputfile); 
			//add data to csv
			String[] data = contact.toString().split(",");
			writer.writeNext(data);
			// closing writer connection 
			writer.close(); 
		} 
		catch (IOException exception) { 
			exception.printStackTrace(); 
		} 
	} 
	public static void readAddressBookCSV() 
	{ 
	    try {  
	        FileReader filereader = new FileReader(Paths.get("addressBook.csv").toFile()); 
	        CSVReader csvReader = new CSVReaderBuilder(filereader).build();  
	        List<String[]> contactData = csvReader.readAll(); 
	        // print Data 
	        for (String[] row : contactData) { 
	            for (String cell : row) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception exception) { 
	        exception.printStackTrace(); 
	    } 
	} 

	public void readDataGSON(IOServices ioService) {
		if (ioService.equals(IOServices.FILE_IO)) {
			new AddressBookFileService().readDataGSON();
		}
	}

	public void writeDataGSON(IOServices ioService) {
		if (ioService.equals(IOServices.FILE_IO)) {
			new AddressBookFileService().writeDataGSON(stateAddressBookMap);
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
			System.out.println("14. Writing data to file");
			System.out.println("15. Reading data from File");
			System.out.println("16. Writing data to CSVFile");
			System.out.println("17. Reading data from CSVFile");
			System.out.println("18. Writing data to JSON file");
			System.out.println("19. Reading data from JSON File");
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
					p = new person(firstName, lastName, address, city, state, zip, phoneNumber, email);
					
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
					String searchName = sc.nextLine();
					System.out.println("Enter the city");
					String cityName = sc.nextLine();
					addBookMain.searchPersonByCity(searchName, cityName);
					break;
				case 7:
					System.out.println("Enter the name to search");
					String personName = sc.nextLine();
					System.out.println("Enter the state");
					String stateName = sc.nextLine();
					addBookMain.searchPersonByCity(personName, stateName);
					break;
				case 8:
					System.out.println("Enter the city");
					String cityData = sc.nextLine();
					addBookMain.viewDataByCity(cityData);
					break;
				case 9:
					System.out.println("Enter the state");
					String stateData = sc.nextLine();
					addBookMain.viewDataByState(statData);
					break;
				case 10:
					System.out.println("Enter the city");
					String cityCount = sc.nextLine();
					addBookMain.countByCity(cityCount);
					break;
				case 11:
					System.out.println("Enter the city");
					String stateCount = sc.nextLine();
					addBookMain.countByState(stateCount);
					break;
				case 12:
					addBookMain.sortByName();
					break;
				case 13:
					addBookMain.sortByZip();
					break;
				case 14:
					addBookMain.writeData(IOService.FILE_IO);
					break;
				case 15:
					addBookMain.readData(IOService.FILE_IO);
					break;
				case 16:
					addBookMain.writeContactAsCSV(person contact);
					break;
				case 17:
					addBookMain.readAddressBookCSV();
					break;
				case 18:
					addressBookMain.writeDataGSON(IOServices.FILE_IO);
					break;
				case 19:
					addressBookMain.readDataGSON(IOServices.FILE_IO);
					break;
				default:
					System.out.println("Enter correct input");
					break;
			}
		}
	}
}