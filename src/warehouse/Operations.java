package warehouse;
import java.util.Scanner;

public class Operations {

    // Defined as a class constant so it may be used anywhere within the class
    public static final Scanner input = new Scanner(System.in);
    
    // Displays main menu options
    public static void mainMenu() {
	int selection;
	System.out.println("Welcome to the Buffalo Rock Company System");
	System.out.println("Select Menu Item:");
	System.out.println("Press 1) Modify Rows or Locations");
	System.out.println("Press 2) Display Warehouse Contents");
	System.out.println("Press 3) Sign off");
	selection = input.nextInt();
	if (selection == 1) {
	    modifyContents();
	} else if (selection == 2) {
	    displayContents();
	} else if (selection == 3) {
	    System.exit(0);
	} else {
	    System.out.println("Menu item does not exist, please try again.");
	    mainMenu();
	}
    }

    public static void modifyContents() {
	int selection;
	System.out.println("Press 1 to add a row");
	System.out.println("Press 2 to remove a row");
	System.out.println("Press 3 to add a location");
	System.out.println("Press 4 to remove a location");
	System.out.println("Press 5 to return to main menu");
	selection = input.nextInt();
	if (selection == 1) {
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
    }

    public static void displayContents() {
	System.out.println("Not yet implemented");
    }
}
