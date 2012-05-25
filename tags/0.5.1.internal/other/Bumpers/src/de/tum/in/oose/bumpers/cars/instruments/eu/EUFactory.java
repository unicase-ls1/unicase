package de.tum.in.oose.bumpers.cars.instruments.eu;

import de.tum.in.oose.bumpers.cars.UserCar;
import de.tum.in.oose.bumpers.cars.instruments.Body;
import de.tum.in.oose.bumpers.cars.instruments.GPS;
import de.tum.in.oose.bumpers.cars.instruments.InstrumentFactory;
import de.tum.in.oose.bumpers.cars.instruments.RotationsPerSecond;
import de.tum.in.oose.bumpers.cars.instruments.SpeedController;
import de.tum.in.oose.bumpers.cars.instruments.Speedometer;

public class EUFactory extends InstrumentFactory {
	
	private static EUFactory INSTANCE;
	
	private EUFactory(){
		//singleton constructor
	}
	
	public static InstrumentFactory getInstance(){
		if(INSTANCE == null){
			INSTANCE = new EUFactory();
		}
		return INSTANCE;
	}
	public RotationsPerSecond createRotationsPerSecond(UserCar theCar) {
		return new EURotationsPerSecond(theCar);
	}
	
	public SpeedController createSpeedController(UserCar theCar) {
		return new EUSpeedController(theCar);
	}
	
	public Speedometer createSpeedometer(UserCar theCar) {
		return new EUSpeedometer(theCar);
	}
	
	public Body createBodyView(UserCar theCar) {
		return new EUBody(theCar);
	}
	
	public GPS createGPS(UserCar theCar) {
		return new EUGPS(theCar);
	}
}

