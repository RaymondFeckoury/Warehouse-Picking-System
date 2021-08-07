package warehouse;

import java.util.ArrayList;

public class Order {

    // Compare indexes from this array with that of Assignments.slots[index].getRow()
    public static char[] rowOrder = {
	A, C, B, D, E, G, H, I, K, F, J, L, N, P, O, R, Q
    };

    // This array is assigned to Assignments.slots once elements are sorted
    public Assignments[] organizedSlots;

    public static void setRoute() {
	// will hold the array which gets assigned to slots
	organizedSlots = new Assignments[Assignments.slots.length];
	// Identifies matching rows
	for (int i = 0; i < Order.rowOrder.length; i++) {
	    char preferredRow = Order.rowOrder[i];
	    ArrayList<Integer> matchingIndexes = new ArrayList<Integer>();
	    // Checks that at least one matching row is present before entering loops
	    if (Row.rowID.contains(preferredRow)) {
		// Adds each matching row to the matching indexes array list
		for (int x = 0; x < Assignments.slots.length; x++) {
		    if (Assignments.slots[x].getRow == preferredRow) {
			matchingIndexes.add(x);
		    }
		}

		// Puts the assignments in organizedSlots based on location (smallest first) using insertion sort
		for (int y = 0; y < matchingIndexes.size(); y++) {
		    int currentLocation = Assignments.slots[matchingIndexes[y]].getLocation();
		    int nextIndex = y + 1;
		    while (nextIndex < matchingIndexes.size()) {
			int nextLocation = Assignments.slots[matchingIndexes[nextIndex]].getLocation();
			if (currentLocation > nextLocation) {

			} else {

			}
			nextIndex++;
		    }
		}
	    }
	}
    }

}
