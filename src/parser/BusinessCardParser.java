package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class BusinessCardParser {
	static String testOption;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Business Card Parser");
		System.out.println("Please Enter Either 'Test X' to run tests 1-3, 'Self Test' to run a new test, or 'Exit' to quit");
		
		while(!readInput().equals("Exit")) {
			ContactInfo info = getContactInfo(testOption);
			System.out.println("\n");
			System.out.println("Name: " + info.getName());
			System.out.println("Email: " + info.getEmailAddress());
			System.out.println("Number: " + info.getPhoneNumber());
		}
		
		input.close();
		System.out.println("Exiting Application!");

	}
	
	private static String readInput() {
		String userInput;
		System.out.print("Enter: ");
		
		userInput = input.nextLine();
		switch(userInput) {
			case "Test 1":
				testOption = "test1.txt";
				return "test1.txt";
			case "Test 2":
				testOption = "test2.txt";
				return "test2.txt";
			case "Test 3": 
				testOption = "test3.txt";
				return "test3.txt";
			case "Self Test":
				System.out.print("Enter the name of your .txt file: ");
				String newTest = input.nextLine();
				File testFile = new File(newTest);
				if(testFile.exists()) {
					testOption  = newTest;
					return newTest;
				} else {
					System.out.println("File does not exist. Running Test 1.");
					testOption = "test1.txt";
					return "test1.txt";
				}
			case "Exit": 
				testOption = "Exit";
				return "Exit";
			default: 
				System.out.println("Invalid Input. Running Test 1.");
				testOption = "test1.txt";
				return "test1.txt";
		}	
	}
	
	 static ContactInfo getContactInfo(String document) {
	    String line;
	
	    ParseName nameParser = new ParseName();
	    ParseEmail emailParser = new ParseEmail();
	    ParseNumber numberParser = new ParseNumber();
		 
	    try {
			FileReader fd = new FileReader(document);
			BufferedReader bf = new BufferedReader(fd);
			while((line = bf.readLine()) != null) {
				emailParser.checkIfEmail(line);
				numberParser.checkIfNumber(line);
				nameParser.checkIfName(line);
			}
			bf.close();
		} catch(Exception e) {
			
		}
		
	    
		ContactInfo card = new ContactInfo(nameParser.returnName(),emailParser.returnEmail(),numberParser.returnNumber());
		return card;
	}
		

}

