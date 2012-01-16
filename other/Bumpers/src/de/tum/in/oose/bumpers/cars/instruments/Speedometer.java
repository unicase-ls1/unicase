package de.tum.in.oose.bumpers.cars.instruments;

import de.tum.in.oose.bumpers.cars.UserCar;

public abstract class Speedometer extends Instrument {
	
	private static final long serialVersionUID = 1L;

	public Speedometer(UserCar theCar){
		super(theCar);
	}
	
}
