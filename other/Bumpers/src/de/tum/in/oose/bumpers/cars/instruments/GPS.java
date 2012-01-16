package de.tum.in.oose.bumpers.cars.instruments;

import de.tum.in.oose.bumpers.cars.UserCar;

public abstract class GPS extends Instrument {
	
	private static final long serialVersionUID = 1L;

	public GPS(UserCar theCar){
		super(theCar);
	}
	
}
