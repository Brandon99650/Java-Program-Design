package hw2.impl;


import hw2.CarbonFootprint;
import hw2.CarbonFootprintServices;

public class Motorbike implements CarbonFootprint {

	private static double FOOTPRINT_PER_MILE_PER_GALLON = .08765;

	private String id;
	private double miles;
	private double milesPerGallon;

	public Motorbike(String id, double miles, double milesPerGallon) {
		setId(id);
		setMiles(miles);
		setMilesPerGallon(milesPerGallon);
	}

	
	@Override
	public double getCarbonFootprint() {
		return ((FOOTPRINT_PER_MILE_PER_GALLON * getMiles()) / getMilesPerGallon());
	}

	
	public String getId() {
		return id;
	}

	
	public double getMiles() {
		return miles;
	}

	
	public double getMilesPerGallon() {
		return milesPerGallon;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	
	public void setMiles(double miles) {
		this.miles = miles;
	}

	
	public void setMilesPerGallon(double milesPerGallon) {
		this.milesPerGallon = milesPerGallon;
	}

	
	public String toString() {
		CarbonFootprintServices service = new CarbonFootprintServices();
		StringBuilder string = new StringBuilder();
		string.append(getId());
		string.append("\nMiles Travelled: " + service.toCommaNumber(getMiles()));
		string.append("\nMiles per gallon: "
				+ service.toCommaNumber(getMilesPerGallon()));
		return string.toString();
	}

}
