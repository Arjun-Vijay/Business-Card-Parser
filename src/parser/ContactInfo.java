package parser;

public class ContactInfo {
	String name;
	String email;
	String phoneNumber;
	
	public ContactInfo(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return String describing the full name of individual
	 */
	String getName() {
		return this.name;
	} 
	
	/** 
	 * @return String describing the email address of individual
	 */
	String getEmailAddress() {
		return this.email;
	}
	
	/**
	 * @return String describing the phone number formatting as a sequence of digits
	 */
	String getPhoneNumber(){
		return this.phoneNumber;
	}
	
}

