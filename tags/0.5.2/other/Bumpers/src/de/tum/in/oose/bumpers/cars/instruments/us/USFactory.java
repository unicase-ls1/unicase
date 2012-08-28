package de.tum.in.oose.bumpers.cars.instruments.us;

import de.tum.in.oose.bumpers.cars.UserCar;
import de.tum.in.oose.bumpers.cars.instruments.Body;
import de.tum.in.oose.bumpers.cars.instruments.GPS;
import de.tum.in.oose.bumpers.cars.instruments.InstrumentFactory;
import de.tum.in.oose.bumpers.cars.instruments.RotationsPerSecond;
import de.tum.in.oose.bumpers.cars.instruments.SpeedController;
import de.tum.in.oose.bumpers.cars.instruments.Speedometer;

public class USFactory extends InstrumentFactory {
	
	private static USFactory INSTANCE;
	
	private USFactory(){
		//singleton constructor
	}
	
	public static InstrumentFactory getInstance(){
		if(INSTANCE == null){
			INSTANCE = new USFactory();
		}
		return INSTANCE;
	}
	public RotationsPerSecond createRotationsPerSecond(UserCar theCar) {
		return new USRotationsPerSecond(theCar);
	}
	
	public SpeedController createSpeedController(UserCar theCar) {
		return new USSpeedController(theCar);
	}
	
	public Speedometer createSpeedometer(UserCar theCar) {
		return new USSpeedometer(theCar);
	}
	
	public Body createBodyView(UserCar theCar) {
		return new USBody(theCar);
	}
	
	public GPS createGPS(UserCar theCar) {
		return new USGPS(theCar);
	}
}

