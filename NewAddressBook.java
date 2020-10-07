import java.util.*;

public class NewAddressBook{
	Scanner sc = new Scanner(System.in);
	public List <person> Book = new ArrayList<person> ();	
	public String city;
	
	public NewAddressBook(String city) {
		this.city = city;
	}
	public List<person> getBook(){
		return Book;
	}
	public void addPerson(person p) {
		for(int i = 0; i<Book.size(); i++) {	
			if(Book.get(i).equals(p)) {
				System.out.println("The person already exists..");
				return;
			}
		}
		Book.add(p);
	}
	
	public void editPerson(String name){
		String x = "";
		int i = 0;
		for(person p : Book) {
			x = p.getFirstName() + " " + p.getLastName();
			if(name.equals(x)) {
				while(true) {
					System.out.println("Enter the number to do the changes");
					System.out.println("1. Address");
					System.out.println("2. City");
					System.out.println("3. State");
					System.out.println("4. ZIP code");
					System.out.println("5. Phone number");
					System.out.println("6. Email id");
					int choice = sc.nextInt();
					sc.nextLine();

					switch(choice) {
						case 1 : 
							System.out.println("Enter new address");
							String address = sc.nextLine();
							p.setAddress(address);
							break;
						case 2 : 
							System.out.println("Enter new city");
							String city = sc.nextLine();
							p.setCity(city);
							break;
						case 3 : 
							System.out.println("Enter new state");
							String state = sc.nextLine();
							p.setAddress(state);
							break;
						case 4 : 
							System.out.println("Enter new ZIP code");
				 			String zip = sc.nextLine();
				 			p.setZip(zip);
				 			break;
						case 5 : 
							System.out.println("Enter new phone number");
				 			long phone = sc.nextLong();
				 			sc.nextLine();
				 			p.setPhoneNumber(phone);
				 			break;
						case 6 : 
							System.out.println("Enter new Email id");
				 			String email = sc.nextLine();
				 			p.setEmail(email);
				 			break;
						}
					}
				}
			Book.set(i, p);
			i++;
		}
	}
	
	public void deletePerson(String name){
		String x = "";
		for(person p : Book) {
			x = p.getFirstName() +" "+p.getLastName();
			if(name.equals(x)) {
				Book.remove(c);
			}
		}
	}
	
	public void viewList() {
		
		for(person p : Book) {
			System.out.println("First Name : " + p.getFirstName() + "Last Name : " + p.getLastName() + " Address : " + p.getAddress() + " City : " + p.getCity() 
							+ " State : " + p.getState() + " ZIP : " + p.getZip() + " Phone Number : " + p.getPhoneNumber() + " Email ID : " + p.getEmail() + "\n");
		}
	}

}