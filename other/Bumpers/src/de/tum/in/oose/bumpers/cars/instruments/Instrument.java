package de.tum.in.oose.bumpers.cars.instruments;

import javax.swing.JPanel;

import de.tum.in.oose.bumpers.cars.UserCar;

public abstract class Instrument extends JPanel {
	
	private static final long serialVersionUID = 1L;
	protected UserCar theCar;
	
	public Instrument(UserCar theDrivenCar){
		this.theCar = theDrivenCar;
	}
	
	public abstract void updateInstrument();
}

