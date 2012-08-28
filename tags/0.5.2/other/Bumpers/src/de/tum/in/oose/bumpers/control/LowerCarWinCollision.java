package de.tum.in.oose.bumpers.control;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import de.tum.in.oose.bumpers.cars.Car;

public class LowerCarWinCollision extends CollisionStrategy {
	
	public String getName() {
		return "Lower Car Win Collision";
	}
	
	public Car detectCollision(Car car1, Car car2){
		Point     p1 = car1.getPosition( );
		Dimension d1 = car1.getSize( );
		Rectangle r1 = new Rectangle(p1, d1);
		r1.translate(p1.x / 8, p1.y / 8);
		r1.grow(-1 * d1.width / 4, -1 * d1.height / 4);
		
		Point     p2 = car2.getPosition( );
		Dimension d2 = car2.getSize( );
		Rectangle r2 = new Rectangle(p2, d2);
		r2.translate(p2.x / 8, p2.y / 8);
		r2.grow(-1 * d2.width / 4, -1 * d2.height / 4);
		
		if (r1.intersects(r2)) {
			if (p1.y < p2.y){
				return car2;
			}else{
				return car1;
			}
		}
		return null;
	}
}

