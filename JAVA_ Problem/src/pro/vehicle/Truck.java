package pro.vehicle;

public class Truck extends Vehicle{
	
	private double fuelEfficiency;
	private double tripDistance;
	
	public Truck(){}
	public Truck( double tripDistance, double fuelEfficiency){
		this.fuelEfficiency = fuelEfficiency;
		this.tripDistance = tripDistance;
	}
	
	@Override
	public double clacFuelEfficiency() {
		return fuelEfficiency;
	}

	@Override
	public double clacTripDistance() {
		return tripDistance;
	}

}
