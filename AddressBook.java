import java.util.*;

public class AddressBook {
	public List <person> personList;
	public AddressBook() {
		personList = new ArrayList<person>();
	}
	
	public void displayAllContacts() {
		System.out.println("DISPLAYING ALL CONTACT DETAILS FROM ADDRESS BOOK");
		for(int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
	}
	
	
	public void addPersonDetails() {
		Scanner sc = new Scanner(System.in);
		
		String checkToAdd = "y";
		
		while(checkToAdd.equalsIgnoreCase("y")) {
			//variables
			String first_name;
			String last_name;
			String address;
			String city;
			String state;
			int zip;
			long  phone_num;
			String email;
			
			System.out.println("Enter following details : ");
			System.out.println("First Name : ");
			first_name = sc.nextLine();
			System.out.println("Last Name : ");
			last_name = sc.nextLine();
			System.out.println("Address : ");
			address = sc.nextLine();
			System.out.println("City : ");
			city = sc.nextLine();
			System.out.println("State : ");
			state = sc.nextLine();
			System.out.println("ZIP : ");
			zip = sc.nextInt();
			System.out.println("Phone number : ");
			phone_num = sc.nextLong();
			sc.nextLine();
			System.out.println("Email ID : ");
			email = sc.nextLine();
			
			person new_person = new person(first_name, last_name, address, city, state, zip, phone_num, email);
			personList.add(new_person);
			
			System.out.println("Enter 'y' to add new person's details.\nEnter any other key to stop.");
			checkToAdd = sc.nextLine();
		}
		
	}
	
	public void editPersonDetails() {
		String FirstName;
		String LastName;
		String address;
		String city;
		String state;
		int zip;
		long  phone_num;
		String email;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name of a person to edit contact details");
		System.out.println("First Name : ");
		FirstName = sc.nextLine();
		System.out.println("Last Name : ");
		LastName = sc.nextLine();
		
		for(int i = 0; i < personList.size(); i++) {
			if(FirstName.equalsIgnoreCase(personList.get(i).first_name) && LastName.equalsIgnoreCase(personList.get(i).last_name)) {
				System.out.println("Address : ");
				address = sc.nextLine();
				System.out.println("City : ");
				city = sc.nextLine();
				System.out.println("State : ");
				state = sc.nextLine();
				System.out.println("ZIP : ");
				zip = sc.nextInt();
				System.out.println("Phone number : ");
				phone_num = sc.nextLong();
				sc.nextLine();
				System.out.println("Email ID : ");
				email = sc.nextLine();
				
				person new_person = new person(FirstName, LastName, address, city, state, zip, phone_num, email);
				personList.set(i, new_person);
			}
		}
	}
	
	public void deletePersonDetails() {
		Scanner sc = new Scanner(System.in);
		String FirstName;
		String LastName;
		
		System.out.println("Enter name of a person to DELETE contact details");
		System.out.println("First Name : ");
		FirstName = sc.nextLine();
		System.out.println("Last Name : ");
		LastName = sc.nextLine();
		
		for(int i = 0; i < personList.size(); i++) {
			if(FirstName.equalsIgnoreCase(personList.get(i).first_name) && LastName.equalsIgnoreCase(personList.get(i).last_name)) {
				personList.remove(personList.get(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("WELCOME TO ADDRESS BOOK");
		
		AddressBook address_book_main = new AddressBook();
		address_book_main.addPersonDetails();
		
		//Displaying all contacts from Address book
		address_book_main.displayAllContacts();
		
		//editing details
		address_book_main.editPersonDetails();
		
		//Displaying all contacts from Address book after editing
		address_book_main.displayAllContacts();
		
		//deleting details
		address_book_main.deletePersonDetails();
		
		//Displaying all contacts from Address book after deleting
		address_book_main.displayAllContacts();
		
	}
}