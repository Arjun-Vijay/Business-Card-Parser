package parser;

public class ParseNumber {
	String number = "";
	
	protected void checkIfNumber(String input) {
		//Check to see if input is a Fax Number
		if(input.contains("f") || input.contains("F")) {
			return;
		}

		//Remove all the non-numbers
		input = input.replaceAll("[^\\d]", "");
		
		if(input.length() == 10 || input.length() == 11) {
			//set phone number 
			number = input;
		}
	}
	
	
	protected String returnNumber() {
		return this.number;
		
	}
	

}
