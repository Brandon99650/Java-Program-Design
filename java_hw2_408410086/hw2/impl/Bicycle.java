package hw2.impl;

import hw2.CarbonFootprint;
import hw2.CarbonFootprintServices;

/**
 * The carbon footprint of cycling a mile was calculated by these values:
 */
public class Bicycle implements CarbonFootprint {

	private static double FOOTPRINT_PER_MILE_AVERAGE = 50;
	private static double FOOTPRINT_PER_MILE_BY_BANANAS = 65;
	private static double FOOTPRINT_PER_MILE_BY_CEREAL_WITH_MILK = 90;
	private static double FOOTPRINT_PER_MILE_BY_BACON = 200;
	private static double FOOTPRINT_PER_MILE_BY_CHEESEBURGERS = 260;
	private static double FOOTPRINT_PER_MILE_BY_AIR_FREIGHTED_ASPARAGUS = 2800;

	private static double GRAM_TO_METRIC_TON_MULTIPLIER = .000001;

	public enum PowerSource {
		AVERAGE_PERSON {
			public String toString() {
				return "Average Person";
			}
		},
		AIR_FREIGHTED_ASPARAGUS {
			public String toString() {
				return "Air-Freighted Asparagus";
			}
		},
		BACON {
			public String toString() {
				return "Bacon";
			}
		},
		BANANAS {
			public String toString() {
				return "Bananas";
			}
		},
		CEREAL_WITH_MILK {
			public String toString() {
				return "Cereal with milk";
			}
		},
		CHEESEBURGERS {
			public String toString() {
				return "Cheeseburgers";
			}
		};
	}

	private String id;
	private double miles;
	private Bicycle.PowerSource powerSource;

	
	public Bicycle(String id, double miles, Bicycle.PowerSource powerSource) {
		setId(id);
		setMiles(miles);
		setPowerSource(powerSource);
	}

	
	@Override
	public double getCarbonFootprint() {
		double footprint = 0;
		switch (getPowerSource()) {
		case AIR_FREIGHTED_ASPARAGUS:
			footprint = getMiles()
					* FOOTPRINT_PER_MILE_BY_AIR_FREIGHTED_ASPARAGUS;
		case BACON:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_BACON;
		case BANANAS:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_BANANAS;
		case CEREAL_WITH_MILK:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_CEREAL_WITH_MILK;
		case CHEESEBURGERS:
			footprint = getMiles() * FOOTPRINT_PER_MILE_BY_CHEESEBURGERS;
		default:
			footprint = getMiles() * FOOTPRINT_PER_MILE_AVERAGE;
		}

		// Convert final footprint to metric tons.
		return footprint * GRAM_TO_METRIC_TON_MULTIPLIER;
	}

	
	public String getId() {
		return id;
	}

	
	public double getMiles() {
		return miles;
	}


	public Bicycle.PowerSource getPowerSource() {
		return powerSource;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setMiles(double miles) {
		this.miles = miles;
	}

	
	public void setPowerSource(Bicycle.PowerSource powerSource) {
		this.powerSource = powerSource;
	}


	public String toString() {
		CarbonFootprintServices service = new CarbonFootprintServices();
		StringBuilder string = new StringBuilder();
		string.append(getId());
		string.append("\nMiles Traveled: " + service.toCommaNumber(getMiles()));
		string.append("\nPowered by: " + getPowerSource().toString());
		return string.toString();
	}
}