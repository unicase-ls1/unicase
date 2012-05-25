package de.tum.in.oose.bumpers.cars.instruments;

import de.tum.in.oose.bumpers.cars.UserCar;

public abstract class InstrumentFactory {
	public abstract Speedometer createSpeedometer(UserCar theCar);
	public abstract RotationsPerSecond createRotationsPerSecond(UserCar theCar);
	public abstract SpeedController createSpeedController(UserCar theCar);
	public abstract GPS createGPS(UserCar theCar);
	public abstract Body createBodyView(UserCar theCar);
}

