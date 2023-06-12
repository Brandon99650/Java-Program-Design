package hw2.impl;

import hw2.CarbonFootprint;
import hw2.CarbonFootprintServices;


public class House implements CarbonFootprint {

	private static double COAL_PER_ONE_KWH = .00034;
	private static double ELECTRICITY_PER_ONE_KWH = .00059;
	private static double HEATING_OIL_PER_ONE_KWH = .00028;
	private static double LPG_PER_ONE_KWH = .00021;
	private static double NATURAL_GAS_PER_ONE_KWH = .00018;
	private static double PROPANE_PER_ONE_GALLON = .00579;
	private static double WOODEN_PELLETS_PER_ONE_METRIC_TON = .00774;

	private double coal;
	private double electricity;
	private double heatingOil;
	private String id;
	private double lpg;
	private double naturalGas;
	private int numberOfPeople;
	private double propane;
	private double woodenPellets;

	public House(String id, int numberOfPeople, double electricity,
			double naturalGas, double heatingOil, double coal, double lpg,
			double propane, double woodenPellets) {

		this.setId(id);
		this.setNumberOfPeople(numberOfPeople);
		this.setElectricity(electricity);
		this.setNaturalGas(naturalGas);
		this.setHeatingOil(heatingOil);
		this.setCoal(coal);
		this.setLpg(lpg);
		this.setPropane(propane);
		this.setWoodenPellets(woodenPellets);
	}

	@Override
	public double getCarbonFootprint() {
		double carbonFootprint = 0;

		carbonFootprint = addElectricity(carbonFootprint);
		carbonFootprint = addNaturalGas(carbonFootprint);
		carbonFootprint = addHeatingOil(carbonFootprint);
		carbonFootprint = addCoal(carbonFootprint);
		carbonFootprint = addLPG(carbonFootprint);
		carbonFootprint = addPropane(carbonFootprint);
		carbonFootprint = addWoodenPellets(carbonFootprint);
		return carbonFootprint;

	}
	public double getCoal() {
		return coal;
	}

	public double getElectricity() {
		return electricity;
	}

	public double getHeatingOil() {
		return heatingOil;
	}

	public String getId() {
		return id;
	}

	public double getLpg() {
		return lpg;
	}

	public double getNaturalGas() {
		return naturalGas;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public double getPropane() {
		return propane;
	}

	public double getWoodenPellets() {
		return woodenPellets;
	}

	public void setCoal(double coal) {
		this.coal = coal;
	}

	public void setElectricity(double electricity) {
		this.electricity = electricity;
	}

	public void setHeatingOil(double heatingOil) {
		this.heatingOil = heatingOil;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLpg(double lpg) {
		this.lpg = lpg;
	}

	public void setNaturalGas(double naturalGas) {
		this.naturalGas = naturalGas;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public void setPropane(double propane) {
		this.propane = propane;
	}

	public void setWoodenPellets(double woodenPellets) {
		this.woodenPellets = woodenPellets;
	}

	
	public String toString() {
		CarbonFootprintServices service = new CarbonFootprintServices();
		StringBuilder string = new StringBuilder();
		string.append(getId());
		string.append("\nNumber of people: " + getNumberOfPeople());
		if (getElectricity() > 0) {
			string.append("\nElectricity used (kWh): "
					+ service.toCommaNumber(getElectricity()));
		}
		if (getNaturalGas() > 0) {
			string.append("\nNatural Gas used (kWh): "
					+ service.toCommaNumber(getNaturalGas()));
		}
		if (getHeatingOil() > 0) {
			string.append("\nHeating Oil used (kWh): "
					+ service.toCommaNumber(getHeatingOil()));
		}
		if (getCoal() > 0) {
			string.append("\nCoal used (kWh): "
					+ service.toCommaNumber(getCoal()));
		}
		if (getLpg() > 0) {
			string.append("\nLPG used (kWh): "
					+ service.toCommaNumber(getLpg()));
		}
		if (getPropane() > 0) {
			string.append("\nPropane used (Gallons): "
					+ service.toCommaNumber(getPropane()));
		}
		if (getWoodenPellets() > 0) {
			string.append("\nWooden Pellets used (Metric Tons): "
					+ service.toCommaNumber(getWoodenPellets()));
		}
		return string.toString();
	}

	private double addCoal(double carbonFootprint) {
		return computeItem(carbonFootprint, coal, COAL_PER_ONE_KWH);
	}

	private double addElectricity(double carbonFootprint) {
		return computeItem(carbonFootprint, electricity,
				ELECTRICITY_PER_ONE_KWH);
	}

	private double addHeatingOil(double carbonFootprint) {
		return computeItem(carbonFootprint, heatingOil, HEATING_OIL_PER_ONE_KWH);
	}

	private double addLPG(double carbonFootprint) {
		return computeItem(carbonFootprint, lpg, LPG_PER_ONE_KWH);
	}

	private double addNaturalGas(double carbonFootprint) {
		return computeItem(carbonFootprint, naturalGas, NATURAL_GAS_PER_ONE_KWH);
	}

	private double addPropane(double carbonFootprint) {
		return computeItem(carbonFootprint, propane, PROPANE_PER_ONE_GALLON);
	}

	private double addWoodenPellets(double carbonFootprint) {
		return computeItem(carbonFootprint, woodenPellets,
				WOODEN_PELLETS_PER_ONE_METRIC_TON);
	}

	private double computeItem(double carbonFootprint, double amount,
			double multiplier) {
		return carbonFootprint + (amount * multiplier);
	}
}
