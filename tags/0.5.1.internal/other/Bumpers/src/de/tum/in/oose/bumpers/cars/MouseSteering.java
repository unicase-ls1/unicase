package de.tum.in.oose.bumpers.cars;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseSteering extends MouseAdapter {
	private UserCar theDrivenCar;
	private GameBoard theField;
	
    public MouseSteering(GameBoard playingField, UserCar dc) {
		theDrivenCar = dc;
		this.theField = playingField;
		this.theField.addMouseListener(this);
    }
	
    public void mousePressed(MouseEvent e) {
		Point carPosition = theDrivenCar.getPosition();
		Point clickPosition = theField.convertPosition(new Point(e.getX(),
																 e.getY()));
		int delta_x = clickPosition.x - carPosition.x;
		delta_x = Math.abs(delta_x);
		int delta_y = clickPosition.y - carPosition.y;
		double diff = ((double)delta_y)/((double)delta_x);
		double theta = Math.atan(diff);
		int degree = (int)Math.toDegrees(theta);
		
		if(clickPosition.x>carPosition.x){
			degree = 90-degree;
		}else{
			degree = 270+degree;
		}
		theDrivenCar.setDirection(degree);
    }
}
