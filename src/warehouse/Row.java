package warehouse;

public class Row {

    // Stores each row ID in the warehouse
    public static char[] rows = new char[1];

    public static Boolean addRow(char id) {
	for (int i = 0; i < rows.length; i++) {
	    if (rows[i] == id) {
		return false;
	    }
	}
	rows[rows.length - 1] = id;
	return true;
    }
}
