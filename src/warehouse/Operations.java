package warehouse;

import java.util.Scanner;

public class Operations {

    // Defined as a class constant so it may be used anywhere within the class
    public static final Scanner input = new Scanner(System.in);
    
    // Displays main menu options
    public static void mainMenu() {
	System.out.println("Welcome to the Buffalo Rock Company System");
	System.out.println("Select Menu Item:");
	System.out.println("Press 1) Modify Rows or Locations");
	System.out.println("Press 2) Display Warehouse Contents");
	System.out.println("Press 3) Sign off");
	// Gathers user input and redirects accordingly
	int selection = input.nextInt();
	if (selection == 1) {
	    modifyContents();
	} else if (selection == 2) {
	    displayContents();
	} else if (selection == 3) {
	    System.out.println("Thank you for using our services.");
	    System.exit(0);
	} else {
	    System.out.println("Menu item does not exist, please try again.");
	    mainMenu();
	}
    }

    // Starting point for the modify rows or locations menu option
    public static void modifyContents() {
	System.out.println("Press 1 to add a row");
	System.out.println("Press 2 to remove a row");
	System.out.println("Press 3 to add a location");
	System.out.println("Press 4 to remove a location");
	System.out.println("Press 5 to return to main menu");
	// Gathers user input and redirects accordingly
	int selection = input.nextInt();
	if (selection == 1) {
	    addRowUI();
	} else if (selection == 2) {
	    removeRowUI();
	} else if (selection == 3) {
	    addLocationUI();
	} else if (selection == 4) {
	    removeLocationUI();
	} else if (selection == 5) {
	    mainMenu();
	}
    }

    public static void addRowUI() {
	System.out.println("Enter Row ID: ");
	char id = input.next().charAt(0);
	if (Row.addRow(id)) {
	    System.out.println("New Row Successfully Created");
	    modifyContents();
	} else {
	    System.out.println("Operation Unsuccessful: A row with this ID already exists.");
	    modifyContents();
	} 	
    }

    public static void removeRowUI() {
	if (Row.getSize() == 0) {
	    System.out.println("No rows currently exist.");
	    modifyContents();
	}
	System.out.println("Choose the row you would like to remove:");
	for (int i = 0; i < Row.getSize(); i++) {
	    System.out.println("Press " + (i + 1) + " to remove: " + Row.getId(i));
	}
	int index = input.nextInt() - 1;
	Row.remove(index);
	System.out.println("Row was removed successfully.");
	modifyContents();
    }

    public static void addLocationUI() {
	System.out.println("Choose the row in which you would like to add the location.");
	 for (int i = 0; i < Row.getSize(); i++) {
	    System.out.println("Press " + (i + 1) + " to add a location to: " + Row.getId(i));
	}
	int rowIndex = input.nextInt() - 1;
	// Variables to be sent as parameters to the location constructor
	int locId;
	String locName;
	double locPrice;
	int locQuantity;
	// Gathers location information from the user
	System.out.println("Please enter the following location information:");
	System.out.println("ID: ");
	locId = input.nextInt();
	// So that scanner doesn't read "/n" as input for the item name
	String throwAway = input.nextLine();
	System.out.println("Name: ");
	locName = input.nextLine();
	System.out.println("Price: ");
	locPrice = input.nextDouble();
	System.out.println("Initial Quantity: ");
	locQuantity = input.nextInt();
	// Creates the location object using the information above and adds it to the row
	Location newLocation = new Location(locId, locName, locPrice, locQuantity);
	Row.getRow(rowIndex).addLocation(newLocation, rowIndex);
	modifyContents();
    }

    public static void removeLocationUI() {
	System.out.println("Which row would you like to remove a location from?");
	for (int i = 0; i < Row.getSize(); i++) {
	    System.out.println("Press " + (i + 1) + " to remove a location from: " + Row.getId(i));
	}
	int rowIndex = input.nextInt() - 1;
	Row localCopy = Row.getRow(rowIndex);
	System.out.println("Locations in row " + Row.getId(rowIndex) + ":");
	for (int i = 0; i < localCopy.locations.size(); i++) {
	    System.out.println("Press " + (i + 1) + " to remove:");
	    System.out.println(localCopy.locations.get(i).locationDetails());
	}
	int locationIndex = input.nextInt() - 1;
	Row.getRow(rowIndex).removeLocation(locationIndex, rowIndex); 
	modifyContents();
    }
    
    public static void displayContents() {
	System.out.println("Press 1 to see all rows");
	System.out.println("Press 2 to see rows along with location ID's");
	System.out.println("Press 3 to see detailed location descriptions");
	System.out.println("Press 4 to return to main menu");
	int selection = input.nextInt();
	if (selection == 1) {
	    System.out.println("Here are all the rows in your warehouse:");
	    for (int i = 0; i < Row.getSize(); i++) {
		System.out.println(Row.getId(i));
	    }
	} else if (selection == 2) {
	    for (int i = 0; i < Row.getSize(); i++) {
		Row localCopy = Row.getRow(i);
		System.out.println("Locations in row " + Row.getId(i) + ":");
		int length = localCopy.locations.size();
		for (int x = 0; x < length; x++) {
		    System.out.println(localCopy.locations.get(x).name);
		}
	    }
	} else if (selection == 3) {
	    for (int i = 0; i < Row.getSize(); i++) {
		Row localCopy = Row.getRow(i);
		int length = localCopy.locations.size();
		for (int x = 0; x < length; x++) {
		    System.out.println("Containing row: " + Row.getId(i) + ", " + localCopy.locations.get(x).locationDetails());
		}
	    }
	} else if (selection == 4) {
	    mainMenu();
	}
	displayContents();
    }
}
