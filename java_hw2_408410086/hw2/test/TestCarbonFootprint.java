package hw2.test;

import java.util.ArrayList;
import hw2.CarbonFootprint;
import hw2.impl.Bicycle;
import hw2.impl.Car;
import hw2.impl.House;
import hw2.impl.Motorbike;


public class TestCarbonFootprint {

	
	public static void main(String[] args) {
		TestCarbonFootprintServices service = new TestCarbonFootprintServices();
		ArrayList<CarbonFootprint> footprintItems = new ArrayList<CarbonFootprint>();
		double totalFootprint = 0;

		// Print out an introduction.
		service.outputIntroduction();
		try {
			footprintItems.add(new House("My House", 2, 100, 100, 100, 100,
					100, 100, 0));
			footprintItems.add(new Car("My Mini Cooper S", 10000, 25));
			footprintItems.add(new Motorbike("My Vespa Scooter", 1000, 60));
			footprintItems.add(new Bicycle("My Bicycle", 1000,
					Bicycle.PowerSource.CHEESEBURGERS));

			// Loop through all items and print out the information.
			for (CarbonFootprint item : footprintItems) {
				double footprint = item.getCarbonFootprint();
				totalFootprint += footprint;
				System.out.println("\nItem: " + item.toString());

				System.out.println("\tCarbon footprint: "
						+ service.toCommaNumber(service.toFloat(2, footprint))
						+ " Metric Tons of CO2");
			}

			System.out.println("\nTotal carbon footprint for this session: "
					+ service.toFloat(2, totalFootprint)
					+ " Metric Tons of CO2");
		} catch (Exception exception) {
			System.out.println("Error.");
		}
	}
}