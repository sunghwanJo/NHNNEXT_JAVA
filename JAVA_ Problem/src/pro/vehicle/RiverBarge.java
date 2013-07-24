package pro.vehicle;

public class RiverBarge extends Vehicle{
	
	private double fuelEfficiency;
	private double tripDistance;
	
	public RiverBarge(){}
	public RiverBarge( double tripDistance, double fuelEfficiency){
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
