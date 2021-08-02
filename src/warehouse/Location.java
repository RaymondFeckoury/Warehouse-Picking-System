package warehouse;

public class Location {

    public String name;
    private int initialQuantity;
    private double price;
    private int id; 

    public Location(int id, String name, double price, int initialQuantity) {
	this.name = name;
	this.price = price;
	this.initialQuantity = initialQuantity;
	this.id = id;
    }

    public String locationDetails() {
	String locationContents = "";
	locationContents = locationContents + "ID: " + id + ", ";
	locationContents = locationContents + "Name: " + name + ", ";
	locationContents = locationContents + "Price: " + price + ", ";
	locationContents = locationContents + "Initial Quantity: " + initialQuantity;
	return locationContents;
    }
    
}
