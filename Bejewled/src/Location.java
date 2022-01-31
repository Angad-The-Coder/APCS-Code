
/**
 * This class encapsulates the row and column of a location in a 2D array. Write the entire class
 * using appropriate class design concepts.
 */
public class Location {
	private int row;
	private int col;

	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}
}
