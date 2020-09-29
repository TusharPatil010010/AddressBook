package AddressBookMain;

public class person {

	public String first_name;
	public String last_name;
	public String address;
	public String city;
	public String state;
	public int zip;
	public long  phone_num;
	public String email;
	
	public person(String first_name, String last_name, String address, String city, String state, int zip, long phone_num, String email) {

		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone_num = phone_num;
		this.email = email;
	}
	
	public String toString() {

		String details = "First Name : " + first_name + "\nLast Name : " + last_name + "\nAddress : " + address + "\nCity : " + city 
							+ "\nState : " + state + "\nZIP : " + zip + "\nPhone Number : " + phone_num + "\nEmail ID : " + email + "\n";
		return details;
	}
}