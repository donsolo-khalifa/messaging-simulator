package challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Contact> arrContacts;
	static ArrayList<Message> arrMessages;
	static Scanner scan = new Scanner(System.in);
	static int id = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrContacts = new ArrayList<>();
		arrMessages = new ArrayList<>();
		showOptions();
	}

	private static void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Good day" + "\n\t1 Manage contacts" + "\n\t2 Messages" + "\n\t3 Quit");
		int option = scan.nextInt();
		switch (option) {
		case 1: {
			System.out.println("Contacts" + "\n\t1 Show all contacts" + "\n\t2 Add a new contact"
					+ "\n\t3 Search for a contact" + "\n\t4 Delete contact" + "\n\t5 Go back to previous menu");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				showAllContacts();
				break;
			}
			case 2: {
				addContacts();
				break;
			}
			case 3: {
				searchContact();
				break;
			}
			case 4: {
				deleteContact();
				break;
			}
			default:
				showOptions();
			}

		}
		case 2: {
			System.out.println("Contacts" + "\n\t1 See list of all messages" + "\n\t2 Send a new message"
					+ "\n\t3 Go back to previous menu");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				showMessage();
				break;
			}
			case 2: {
				sendMessage();
				break;
			}
			default:
				showOptions();
			}
		}
		default: 
			break;
		
		}

	}

	private static void sendMessage() {
		// TODO Auto-generated method stub
		System.out.println("who do you want to text?");
		String receiver = scan.next();
		System.out.println("what would you like to say?");
		String text = scan.next();
		id++;

		for (Contact c : arrContacts) {
			if (receiver.equalsIgnoreCase(c.getName()) || receiver.equalsIgnoreCase(c.getNumber())) {
				arrMessages.add(new Message(text, receiver, id));
				System.out.println("Message was sent!");
			} else {
				System.out.println("contact does not exist");
			}

		}
	}

	private static void showMessage() {
		// TODO Auto-generated method stub
		for (Message m : arrMessages) {
			if (!arrMessages.isEmpty()) {
				m.getDetails();
			} else {
				System.out.println("you do not have any messages");
			}

		}
		showOptions();
	}

	private static void deleteContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter the contact name or number to delete");
		String name = scan.next();
		boolean doesExist = false;
		for (Contact c : arrContacts) {
			if (name.equalsIgnoreCase(c.getName()) || name.equalsIgnoreCase(c.getNumber())) {
				doesExist = true;
				arrContacts.remove(c);
				System.out.println("contact deleted");
			} else {
				doesExist = false;
			}
		}
		if (doesExist == false) {
			System.out.println("contact does not exist");
		}
		showOptions();
	}

	private static void searchContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter the contact name or number");
		String name = scan.next();
		for (Contact c : arrContacts) {
			if (name.equalsIgnoreCase(c.getName()) || name.equalsIgnoreCase(c.getNumber())) {
				c.getDetails();
			} else {
				System.out.println("contact does not exist");
			}
		}
		showOptions();
	}

	private static void addContacts() {
		// TODO Auto-generated method stub
		String name;
		String number;
		System.out.println("enter name to add");
		name = scan.next();
		if (name.strip() == "") {
			System.out.println("Contact name can not be blank ");
			addContacts();
		} else {

			System.out.println("enter the number");
			number = scan.next();
			if (number.trim() == "") {
				System.out.println("contact number can not be empty re-enter the niumber");
				number = scan.next();
			}
			arrContacts.add(new Contact(name, number));
		}
		System.out.println("contact added");
		showOptions();

	}

	private static void showAllContacts() {
		// TODO Auto-generated method stub
		if (!arrContacts.isEmpty()) {
			for (Contact c : arrContacts) {
				c.getDetails();
			}
		} else {
			System.out.println("No contacts to show");
		}
		showOptions();
	}

}
