//package emailapp;

import java.util.Scanner;
import java.io.*;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private final String passwordSet =  "ABCDEFGHIJKLMNOPQRS" 
                           + "TUVWXYZ0123456789!@#$%";
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String department;
    private String password;


    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	emailAddress = firstName + "." + lastName + "@"
	    + companySuffix;
	randomPassword(defaultPasswordLength);
	Scanner scanner = new Scanner(System.in);
	System.out.println("New Worker: " + firstName + " " 
			   + lastName + ". Department Codes:");
	department = SetDepartment();
    }

    // Ask for the department
    private String SetDepartment() {
	Scanner scanner= new Scanner(System.in);
	while (true) {
	    System.out.println("1 for Sales");
	    System.out.println("2 for Development");
	    System.out.println("3 for Accounting");
	    System.out.println("0 for none");
	    System.out.println("Enter department code: ");
	    String line = scanner.nextLine();
	    if (line.equals("1")) {
		scanner.close();   
		return "Sales";
	    } else if (line.equals("2")) {
		scanner.close();   
		return "Development";
	    } else if (line.equals("3")) {
		scanner.close();   
		return "Accounting";
	    } else if (line.equals("0")) {
		scanner.close();   
		return "none";
	    } 
	}
	
    }

    // Generate a random password
    private String randomPassword(int length) {
	password = "";
	for (int i = 0; i < length; i++) {
	    int pos = (int) (Math.random() * passwordSet.length());
	    this.password += passwordSet.charAt(pos);
	}
	return password;
    }

    public String showInfo() {
	String info = "";
	info += "DISPLAY NAME: " + firstName + " " 
               + lastName + "\n";
	info += "DEPARTMENT: " + department + "\n";
	info += "COMPANY EMAIL: " + emailAddress + "\n";
	info += "PASSWORD: " + password + "\n";
	info += "MAILBOX CAPACITY: " + mailboxCapacity 
               + "mb\n";
	return info;
    }


}

