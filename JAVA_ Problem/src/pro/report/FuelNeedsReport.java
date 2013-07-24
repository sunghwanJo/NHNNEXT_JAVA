package pro.report;

import java.io.PrintStream;

import pro.company.Company;
import pro.vehicle.Vehicle;

public class FuelNeedsReport {
	
	Company company = Company.getInstance();
	
	public void generateText(PrintStream out) {

		for(Vehicle vehicle : company.vehicles){
			out.println(vehicle.calFuelNeeds());
		}
		
	}

}
