package hw2;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class CarbonFootprintServices {
	
	public String toCommaNumber(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat();
		df.setDecimalFormatSymbols(dfs);
		return df.format(number);
	}

}
