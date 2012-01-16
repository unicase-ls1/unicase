package de.tum.in.oose.bumpers.cars;

import java.awt.Image;

public class FastCar extends Car {
	public static Image DEFAULT_FAST_CAR_IMAGE;
	
	public FastCar(int max_x,
				   int max_y){
		super();
		initiate(max_x, max_y);
	}
	
	public void initiate(int max_x, int max_y) {
		this.MIN_SPEED = 5;
		this.MAX_SPEED = 10;
		setBody(DEFAULT_FAST_CAR_IMAGE);
		super.initiate(max_x, max_y);
	}
}

