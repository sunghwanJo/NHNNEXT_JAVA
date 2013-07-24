package pro.company;

import java.util.ArrayList;

import pro.vehicle.Vehicle;

public class Company {
	public ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	// Singleton Pattern을 위한 변수 
	private static Company instance;
	
	private Company(){}
	
	public static Company getInstance() {
		if(instance == null)
			instance = new Company();
		
		return instance;
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	

}
