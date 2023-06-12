package hw2.test;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public final class TestCarbonFootprintServices {
	
	public double toFloat(int digits, double number) {
		StringBuilder format = new StringBuilder();

		format.append("#.");
		for (int i = 1; i <= digits; i++) {
			format.append("#");
		}
		// format.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat(format.toString());
		return Double.valueOf(df.format(number)).doubleValue();
	}

	
	public String toCommaNumber(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat();
		df.setDecimalFormatSymbols(dfs);
		return df.format(number);
	}

	/**
	 * Outputs the program introduction.
	 */
	public void outputIntroduction() {
		
		System.out
				.println("\nThis  creates an array that share an interface.");
		System.out
				.println("It will prints  the carbon footprint .");
		return;
	}

}
