package warehouse;

import java.util.ArrayList;

public class Order {

    // Compare indexes from this array with that of Assignments.slots[index].getRow()
    public static char[] rowOrder = new char[] {
	'A', 'C', 'B', 'D', 'E', 'G', 'H', 'I', 'K',
	'F', 'J', 'L', 'M', 'N', 'P', 'O', 'R', 'Q'
    };

    // This array is assigned to Assignments.slots once elements are sorted
    public static Assignments[] organizedSlotsRow;
    public static Assignments[] organizedSlotsLocation;
    
    /*
     * Places the assignments in the correct order.
     */
    public static void setRoute() {
	// Sets the organized slots array to the proper length
	Order.organizedSlotsRow = new Assignments[Assignments.slots.length];
	int organizedIndex = 0;
	// Loops through the rows in order for comparison 
	for (int i = 0; i < Order.rowOrder.length; i++) {
	    char current = Order.rowOrder[i];
	    // Adds the row to the list if it contains the current row in order
	    for (int j = 0; j < Assignments.slots.length; j++) {
		if (current ==  Assignments.slots[j].getRow()) {
		    Order.organizedSlotsRow[organizedIndex] = Assignments.slots[j];
		    organizedIndex++;
		}
	    }
	}

	Order.organizedSlotsLocation = new Assignments[Order.organizedSlotsRow.length];
	int organizedCounter = 0;
	// Sorts based on location
	for (int k = 0; k < Order.organizedSlotsRow.length; k++) {
	    Assignments smallestAssignment = Order.organizedSlotsRow[k];
	    // Adds the final element once we have reached the end of the array
	    if (k + 1 == Order.organizedSlotsRow.length) {
		Order.organizedSlotsLocation[organizedCounter] = smallestAssignment;
		break;
	    }
	    // Stores the next assignment for comparison
	    int nextIndex = k + 1;
	    Assignments nextAssignment = Order.organizedSlotsRow[nextIndex];
	    // Keeps making comparisons until we are at a new row
	    while (nextAssignment.getRow() == smallestAssignment.getRow()) {
		if (nextAssignment.getLocation() < smallestAssignment.getLocation()) {
		    smallestAssignment = nextAssignment;
		}
		// To avoid aioobe
		if (nextIndex + 1 < Order.organizedSlotsRow.length) {
		    nextIndex++;
		    nextAssignment = Order.organizedSlotsRow[nextIndex];
		}
	    }
	    Order.organizedSlotsLocation[organizedCounter] = smallestAssignment;
	    organizedCounter++;
	}
	Assignments.slots = Order.organizedSlotsLocation;
    }

}
