package warehouse;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class Row {

    // Stores each row ID in the warehouse
    private static ArrayList<Character> rows = new ArrayList<Character>();

    // Stores each location that a specific row contains
    private Location[] locations = new Location[0];

    public static Boolean add(char id) {
	if (rows.contains(id)) {
	    return false;
	}
	return rows.add(id);
    }

    public static void remove(int index) {
	try {
	    rows.remove(index);
	} catch (IndexOutOfBoundsException ioobe) {
	    System.out.println("Error: invalid number was entered.");
	}
    }

    public static int getSize() {
	return rows.size();
    }

    public static char get(int index) {
	return rows.get(index);
    }
}
