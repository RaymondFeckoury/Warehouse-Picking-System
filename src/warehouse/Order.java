package warehouse;

import java.util.ArrayList;

public class Order {

    // Compare indexes from this array with that of Assignments.slots[index].getRow()
    public static char[] rowOrder = {
	A, C, B, D, E, G, H, I, K, F, J, L, N, P, O, R, Q
    };

    public static void setRoute() {
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

		// Puts the assignments in organizedSlots (smallest first, insertion sort)
		for (int y = 0; y < matchingIndexes.size(); y++) {
		    int currentLocation = Assignments.slots[matchingIndexes[y]].getLocation();
		    // Ensures we don't get an AIOOBE
		    if (y + 1 < matchingIndexes.size()) {
			int nextIndex = y + 1;
			while (nextIndex < matchingIndexes.size()) {
			    int nextLocation =
				Assignments.slots[matchingIndexes[nextIndex]].getLocation();
			    if (currentLocation > nextLocation) {
				nextIndex++;
			    } else {
				
			    }
			}
		    } else {
			// If we are at the end of the list, this adds the final element,
			// which is the last in order, to the organized array
			Assignments nextInOrder =
			    new Assignments(preferredRow, currentLocation);
			/*
			 * What will the index be?
			 */
			//organizedSlots[] = nextInOrder;
		    }
		}
	    }
	}
    }

}
