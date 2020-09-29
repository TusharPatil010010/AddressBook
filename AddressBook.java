import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {

		//variables
		String first_name;
		String last_name;
		String address;
		String city;
		String state;
		int zip;
		long  phone_num;
		String email;
		
		System.out.println("Welcome to Address Book");

		//Taking input from console
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your First Name : ");
		first_name = sc.nextLine();

		System.out.println("Enter your Last Name : ");
		last_name = sc.nextLine();

		System.out.println("Enter your Address : ");
		address = sc.nextLine();

		System.out.println("City : ");
		city = sc.nextLine();

		System.out.println("State : ");
		state = sc.nextLine();

		System.out.println("ZIP : ");
		zip = sc.nextInt();

		System.out.println("Enter your Phone number : ");
		phone_num = sc.nextLong();
		sc.nextLine();

		System.out.println("Enter your Email ID : ");
		email = sc.nextLine();

		//calling person class
		person person1 = new person(first_name, last_name, address, city, state, zip, phone_num, email);
		
	}
}