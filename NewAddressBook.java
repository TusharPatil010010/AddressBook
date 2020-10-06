public class NewAddressBook{
	Scanner sc = new Scanner(System.in);
	public List<Contact> Book = new ArrayList<Contact>();	
	public String city;
	
	public AddressBook(String city) {
		this.city = city;
	}
	public List<Contact> getBook(){
		return Book;
	}
	public List<Contact> addContact(Contact c) {
		Book.add(c);
		return Book;
	}
	
	public void editContact(String name){
		String x = "";
		int i = 0;
		for(Contact c : Book) {
			x = c.getFirstName() + " " + c.getLastName();
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
							c.setAddress(address);
							break;
						case 2 : 
							System.out.println("Enter new city");
							String city = sc.nextLine();
							c.setCity(city);
							break;
						case 3 : 
							System.out.println("Enter new state");
							String state = sc.nextLine();
							c.setAddress(state);
							break;
						case 4 : 
							System.out.println("Enter new ZIP code");
				 			String zip = sc.nextLine();
				 			c.setZip(zip);
				 			break;
						case 5 : 
							System.out.println("Enter new phone number");
				 			long phone = sc.nextLong();
				 			sc.nextLine();
				 			c.setPhoneNumber(phone);
				 			break;
						case 6 : 
							System.out.println("Enter new Email id");
				 			String email = sc.nextLine();
				 			c.setEmail(email);
				 			break;
						}
					}
				}
			Book.set(i, c);
			i++;
		}
	}
	
	public void deleteContact(String name){
		String x = "";
		for(Contact c : Book) {
			x = c.getFirstName() +" "+c.getLastName();
			if(name.equals(x)) {
				Book.remove(c);
			}
		}
	}
	
	public void viewList() {
		
		for(Contact c : Book) {
			System.out.println("First Name : " + c.getFirstName() + "Last Name : " + c.getLastName() + " Address : " + c.getAddress() + " City : " + c.getCity() 
							+ " State : " + c.getState() + " ZIP : " + c.getZip() + " Phone Number : " + c.getPhoneNumber() + " Email ID : " + c.getEmail() + "\n");
		}
	}

}