package de.tum.in.oose.bumpers.cars.instruments;

import de.tum.in.oose.bumpers.cars.UserCar;

public class AnalogSpeedometerAdapter extends Instrument{
	
	private static final long serialVersionUID = 1L;
	private AnalogSpeedometer speedometer;
	private int speed;
	
	public AnalogSpeedometerAdapter(UserCar theCar,
									AnalogSpeedometer speedometer){
		super(theCar);
		this.speedometer = speedometer;
		updateInstrument();
	}
	
	
	public void updateInstrument() {
		if(this.speed != theCar.getSpeed()){
			this.speed = theCar.getSpeed();
			
			double percent = (double)theCar.MAX_SPEED/100*this.speed;
			int angle = (int)(speedometer.getMaxAngle()*percent);
			this.speedometer.setAngle(angle);
		}
	}
	
	
}

