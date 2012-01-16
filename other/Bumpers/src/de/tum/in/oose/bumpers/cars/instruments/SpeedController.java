package de.tum.in.oose.bumpers.cars.instruments;

import java.awt.Image;

import de.tum.in.oose.bumpers.cars.UserCar;

public abstract class SpeedController extends Instrument {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Image UP;
	public static Image DOWN;
	
	public SpeedController(UserCar theCar){
		super(theCar);
	}
	
}

