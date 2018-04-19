package StanleysStorage;

/**
 * TemperatureUnit -- stores information about temperature units
 * @author evankoh
 *
 */
public class TemperatureUnit extends Unit {
	private int temp;
	private Location loc;
	private double price;
	
	/**
	 * Constructs a new Temperature Unit
	 * @param width - width of unit
	 * @param height - height of unit
	 * @param length - length of unit
	 * @param temp - the temperature the unit is set at
	 * @param loc - the location this unit belongs to
	 * @throws IllegalArgumentException - when required temperature parameter is outside of set bounds
	 */
	public TemperatureUnit(int width, int height, int length, int temp, Location loc, String unitName) throws IllegalArgumentException {
		super(width, height, length, loc.getBasePrice() + (length * width * height) * 1.0 + calculatePrice(temp), loc, unitName);
		if(temp < 45 || temp > 70) {
			throw new IllegalArgumentException("Tempurature can only be between 45 and 70");
		}
		this.loc = loc;
		this.temp = temp;	
	}
	
	/*
	 * Private function to calculate the temperature surcharge
	 */
	private static double calculatePrice(int temp) {
		if(temp >= 45 && temp <= 49 || temp >= 65 && temp <= 70) {
			return 30.0;
		} else {
			return 0.0;
		}
	}
	
	/**
	 * Returns the temperature of the unit
	 * @return - the temperature of the unit
	 */
	public int getTemperature() {
		return temp;
	}
	
	/**
	 * Sets the temperature of the unit
	 */
	public void setTemperature(int temp) throws IllegalArgumentException {
		if(temp < 45 || temp > 70) {
			throw new IllegalArgumentException("Unit temperature can only be set in the range 45 to 70");
		} else {
			this.temp = temp;
		}
	}
}
