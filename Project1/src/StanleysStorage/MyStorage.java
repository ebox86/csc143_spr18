package StanleysStorage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import StanleysStorage.Unit.unitType;

public class MyStorage {
	
	public static void main(String[] Args) throws Exception {
		Customer cust1 = new Customer("Evan", "5555555555");
		//System.out.println(cust1.toString());
		
		//Unit unit = new Unit(16, 16, 8, 101.0, unitType.STANDARD);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		
		//unit.rent(cust1, today, 100.0);
		//cust1.charge(50.0);
		//cust1.charge(25.0);
		//System.out.println(unit.toString());
		
		Location loc = new Location("WA23Issaquah");
		//System.out.println(loc.toString());
		//System.out.println(loc.getDesignation());
		//System.out.println(loc.getCity());
		
		loc.getUnit(12, 19).rent(cust1, df.parse("04/10/2018"));
		loc.getUnit(12, 20).rent(new Customer("E", "5555555555"), df.parse("04/10/2018"), 15.0);
		loc.chargeRent();
		//loc.getUnit(12, 20).getCustomer().credit(100.0);
		//loc.chargeRent();
		//loc.chargeRent();
		//Unit[] untArr = loc.getEmptyUnits(unitType.STANDARD);
		//System.out.println();
		System.out.println(loc.toString());
		
		
		
	}
}
