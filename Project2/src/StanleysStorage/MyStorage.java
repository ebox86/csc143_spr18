package StanleysStorage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Tests various methods of the StanleyStorage Classes
 * @author evankoh
 * @version csc143
 */
public class MyStorage {
	
	public static void main(String[] Args) {
		Customer cust1 = new Customer("Evan", "5555555555");
		//System.out.println(cust1.toString());
		
		//Unit unit = new Unit(16, 16, 8, 101.0, unitType.STANDARD);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		
		//unit.rent(cust1, today, 100.0);
		//cust1.charge(50.0);
		//cust1.charge(25.0);
		//System.out.println(unit.toString());
		
		Location loc = new Location("WA23Issaquah", 15.0);
		System.out.println(loc.getEmptyUnits().length + " empty units total");
		System.out.println(loc.getEmptyUnits(StandardUnit.class).length + " empty standard units");
		System.out.println(loc.getEmptyUnits(HumidityUnit.class).length + " empty humidity units");
		System.out.println(loc.getEmptyUnits(TemperatureUnit.class).length + " empty temperature units\n\n");
		//System.out.println(loc.toString());
		//System.out.println(loc.getDesignation());
		//System.out.println(loc.getCity());
		
		try {
			loc.getUnit(1, 1).rent(cust1, df.parse("04/18/2018"));
			loc.getUnit(4, 2).rent(cust1, df.parse("04/20/2018"));
			loc.getUnit(6, 3).rent(cust1, df.parse("04/20/2018"));
			loc.getUnit(8, 3).rent(cust1, df.parse("04/20/2018"));
			((HumidityUnit) loc.getUnit(8, 3)).setHumidity(25);
			loc.getUnit(11, 4).rent(cust1, df.parse("04/30/2018"));
			((TemperatureUnit) loc.getUnit(11, 4)).setTemperature(69);
			System.out.println("number of units Cust1 has: " + loc.getUnitsByCustomer(cust1).length + "\n\n");
			loc.getUnit(12, 5).rent(new Customer("E", "5555555555"), df.parse("04/20/2018"));
			loc.getUnit(12, 2).rent(new Customer("E", "5555555555"), df.parse("04/20/2018"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(loc.toString());
		loc.chargeRent();
		loc.chargeRent();
		loc.chargeRent();
		//System.out.println(loc.getCustomerCount());
		System.out.println(loc.unitMap());
		//loc.getUnit(12, 20).getCustomer().credit(100.0);
		loc.chargeRent();
		loc.chargeRent();
		//Unit[] untArr = loc.getEmptyUnits(unitType.STANDARD);
		System.out.println(loc.toString());
		System.out.println(loc.unitMap());
		
		
		
	}
}
