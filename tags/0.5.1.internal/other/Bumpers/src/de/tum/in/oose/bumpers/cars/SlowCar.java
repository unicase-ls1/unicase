package de.tum.in.oose.bumpers.cars;

import java.awt.Image;

public class SlowCar extends Car {
	
	public static Image DEFAULT_SLOW_CAR_IMAGE;
	
	public SlowCar(int max_x,
				   int max_y){
		super();
		initiate(max_x, max_y);
	}
	
	public void initiate(int max_x, int max_y) {
		this.MIN_SPEED = 2;
		this.MAX_SPEED = 5;
		setBody(DEFAULT_SLOW_CAR_IMAGE);
		super.initiate(max_x, max_y);
	}
	
	
}

