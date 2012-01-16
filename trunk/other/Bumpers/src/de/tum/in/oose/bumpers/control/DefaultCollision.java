package de.tum.in.oose.bumpers.control;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import de.tum.in.oose.bumpers.cars.Car;


public class DefaultCollision extends CollisionStrategy{
	public String getName() {
		return "DefaultCollision";
	}
	
	public Car detectCollision(Car car1, Car car2){
		Point     p1 = car1.getPosition( );
		Dimension d1 = car1.getSize( );
		Rectangle r1 = new Rectangle(p1, d1);
		
		
		Point     p2 = car2.getPosition( );
		Dimension d2 = car2.getSize( );
		Rectangle r2 = new Rectangle(p2, d2);
	
		
		if (r1.intersects(r2)) {
			if (p1.x > p2.x){
				return car2;
			}else{
				return car1;
			}
		}
		return null;
	}
}
