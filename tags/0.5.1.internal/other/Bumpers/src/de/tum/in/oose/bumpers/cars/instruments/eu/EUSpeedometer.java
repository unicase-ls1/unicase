package de.tum.in.oose.bumpers.cars.instruments.eu;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import de.tum.in.oose.bumpers.cars.UserCar;
import de.tum.in.oose.bumpers.cars.instruments.Speedometer;

public class EUSpeedometer extends Speedometer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel theLabel = new JLabel("", JLabel.LEFT);
	
	public EUSpeedometer(UserCar theCar){
		super(theCar);
		setLayout(new BorderLayout());
		add(theLabel, BorderLayout.CENTER);
		theLabel.setText(getSpeedText(theCar.getSpeed()));
	}
	
	public void updateInstrument() {
		String newText = getSpeedText(theCar.getSpeed());
		if(!newText.equals(theLabel.getText())){
			theLabel.setText(newText);
		}
	}
	
	protected String getSpeedText(float rotationsPerSecond){
		return "Geschwindigkeit: "+rotationsPerSecond*10*8/5+" km/h";
	}
}

