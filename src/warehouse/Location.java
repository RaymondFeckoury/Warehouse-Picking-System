package warehouse;

public class Location {

    private int id;
    public String name;

    public Location(int id, String name) {
	this.id = id;
	this.name = name;
    }

    public String locationDetails() {
	String locationContents = "";
	locationContents = locationContents + "ID: " + id + ", ";
	locationContents = locationContents + "Name: " + name + ", ";
	return locationContents;
    }

    public int getId() {
	return this.id;
    }
    
}
