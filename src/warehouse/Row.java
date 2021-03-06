package warehouse;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class Row {

<<<<<<< HEAD
    // I hope this is temporary, stores all ID's for checking purposes
    public static ArrayList<Character> rowID = new ArrayList<Character>();
=======
>>>>>>> c50ec6e47845f2f324f0d3fcfc37be17e97d7aea
    
    // Stores each row as an object
    private static ArrayList<Row> rowObject = new ArrayList<Row>();
    private char id; // Each row object has its own unique ID
    // Each row object has its own array list containing location objects
    public ArrayList<Location> locations = new ArrayList<Location>();
    
    public static Boolean addRow(char id) {
	if (rowID.contains(id)) {
	    return false;
	}
	rowID.add(id);
	Row newRow = new Row();
	newRow.setId(id);
	rowObject.add(newRow);
	return true;
    }
    
    public static void setId(char id) {
	id = id;
    }

    public static void remove(int index) {
	try {
	    rowID.remove(index);
	    rowObject.remove(index);
	} catch (IndexOutOfBoundsException ioobe) {
	    System.out.println("Error: invalid number was entered.");
	}
    }

    public static void removeLocation(int locationIndex, int rowIndex) {
	Row removeFrom = rowObject.get(rowIndex);
	removeFrom.locations.remove(locationIndex);
	System.out.println("Location was removed successfully.");
    }

    public static int getSize() {
	return rowID.size();
    }

    public static char getId(int index) {
	return rowID.get(index);
    }

    public static Row getRow(int index) {
	return rowObject.get(index);
    }
    
    public static void addLocation(Location locationObj, int rowIndex) {
	Row addTo = rowObject.get(rowIndex);
	addTo.locations.add(locationObj);
	System.out.println("New location added successfully.");
    }
    
}
