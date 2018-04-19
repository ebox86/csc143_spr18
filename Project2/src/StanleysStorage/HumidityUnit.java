package StanleysStorage;

/**
 * HumidityUnit -- stores information about humidity controlled units
 * @author evankoh
 *
 */
public class HumidityUnit extends Unit {
	private int humidity;
	private Location loc;
	private double price;

	/**
	 * Constructs a new HumidityUnit
	 * @param width - width of unit
	 * @param height - height of unit
	 * @param length - length of unit
	 * @param humidity - the humidity value of the unit
	 * @param loc - the location this unit belongs to
	 * @throws IllegalArgumentException - when required humidity parameter is outside of set bounds
	 */
	public HumidityUnit(int width, int height, int length, int humidity, Location loc, String unitName) throws IllegalArgumentException {
		super(width, height, length, loc.getBasePrice() + ((width * length) * 5.0) + calculatePrice(humidity), loc, unitName);
		if(humidity < 20 || humidity > 60) {
			throw new IllegalArgumentException("Humidity level can only be between 20% and 60%");
		}
		this.loc = loc;
		this.humidity = humidity;
	}
	
	/*
	 * Private function to calculate the humidity surcharge
	 */
	private static double calculatePrice(int level) {
		if(level >= 20 && level <= 29) {
			return 20.0;
		} else {
			return 0.0;
		}
	}
	
	/**
	 * Returns the humidity level of the unit
	 * @return - the humidity level of the unit
	 */
	public int getHumidity() {
		return humidity;
	}
	
	/**
	 * Sets the humidity level of the unit
	 */
	public void setHumidity(int humidity) throws IllegalArgumentException {
		if(humidity < 20 || humidity > 60) {
			throw new IllegalArgumentException("Unit humidity level can only be set in the range 20 to 60");
		} else {
			this.humidity = humidity;
		}
	}
}