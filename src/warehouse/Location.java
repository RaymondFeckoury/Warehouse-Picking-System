package warehouse;
/*
 * This class represents the smallest unit within the warehouse: a location.
 * Locations must store the following: Item name, quantity (starting and current), and
 * price. Order of precedence is
 * managed in the {@code row} class.
 */
public class Location {

    private String name;
    private int initialQuantity;
    private double price;
    private int id; 

    public Location(String name, int price, int initialQuantity, int id) {
	this.name = name;
	this.price = price;
	this.initialQuantity = initialQuantity;
	this.id = id;
    }

    public String locationDetails() {
	String locationContents = "";
	/*locationContents.concat("Name: " + name + "/n");
	locationContents.concat("Price: " + price + "/n");
	locationContents.concat("Initial Quantity: " + initialQuantity + "/n");
	locationContents.concat("ID#: " + id);*/
	locationContents = locationContents + "Name: " + name + "/n";
	locationContents = locationContents + "Price: " + price + "/n";
	locationContents = locationContents + "Initial Quantity: " + initialQuantity + "/n";
	locationContents = locationContents + "ID#: " + id;
	System.out.println(locationContents);
	System.out.println("??");
	return locationContents;
    }
	
    
}
