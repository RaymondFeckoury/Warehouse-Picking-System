package warehouse;

import java.util.Random;

public class Assignments {

    public static Random generate = new Random();
    public static Assignments[] slots;
    public static int numStops;

    // Varies based on number generator and/or warehouse
    public int numLocations;
    public int numRows;
    
    // These variables hold each slot
    private char row;
    private int location;

    // default countructor 
    public Assignments() {
	super();
    }

    public Assignments(char row, int location) {
	this.row = row;
	this.location = location;
    }

    // Does the random assignments
    public static void load() {
	// Generates random number of stops and sizes the array accordingly
	Assignments.numStops = 12 + generate.nextInt(19);
	slots = new Assignments[Assignments.numStops];
	// Loop executes for each stop. Adds assignment object to index in slots array
	for (int i = 0; i < Assignments.numStops; i++) {
	    // to access private instance variables
	    Assignments newSlot = new Assignments();
	    // Stores max index so that random row index may be generated
	    newSlot.numRows = Row.getSize();
	    int rowIndex = generate.nextInt(newSlot.numRows);
	    newSlot.row = Row.getId(rowIndex);
	    Row localCopy = Row.getRow(rowIndex);
	    // Gets the number of locations within the specified row 
	    newSlot.numLocations = localCopy.locations.size();
	    // Assigns a random location
	    int locationIndex = generate.nextInt(newSlot.numLocations);
	    newSlot.location = localCopy.locations.get(locationIndex).getId();
	    newSlot = new Assignments(newSlot.row, newSlot.location);
	    slots[i] = newSlot;
	}
	Assignments.pickingInterface();
    }

    public static void pickingInterface() {
<<<<<<< HEAD
	Order.setRoute();
=======
	//	Order.setRoute();
>>>>>>> c50ec6e47845f2f324f0d3fcfc37be17e97d7aea
	System.out.println("Here are your assignments:");
	// Prints array to see if this worked
	for (int i = 0; i < slots.length; i++) {
	    System.out.println("Assignment #" + (i + 1) + ": " + slots[i].getRow() + ", " + slots[i].getLocation());
	}
    }

    public char getRow() {
	return this.row;
    }

    public int getLocation() {
	return this.location;
    }

}
