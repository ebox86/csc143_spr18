package StanleysStorage;

/**
 * StandardUnit -- stores information about a standard unit
 * @author evankoh
 * @version csc143
 */
public class StandardUnit extends Unit {

	/**
	 * Constructs a new StandardUnit object
	 * @param width - width of unit
	 * @param height - height of unit
	 * @param length - length of unit
	 * @param loc - the location this unit belongs to
	 */
	public StandardUnit(int width, int height, int length, Location loc, String unitName) {
		super(width, height, length, loc.getBasePrice() + 75.0, loc, unitName);
	}

}
