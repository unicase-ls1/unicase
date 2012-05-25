package de.tum.in.oose.bumpers.cars.instruments;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AnalogSpeedometer extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int angle;
	public AnalogSpeedometer(){
		super(true);
		angle = 0;
		setBackground(Color.white);
	}
	
	public void setAngle(int angle){
		if(angle < getMinAngle()
		   || angle > getMaxAngle()){
			throw new IllegalArgumentException("Angle must be between minumum and maximum angle.");
		}
		this.angle = angle;
		repaint();
	}
	
	public int getMinAngle(){ return 0; }
	public int getMaxAngle(){ return 180; }
	
	
	public void paint(Graphics g){
		super.paint(g);
		
		g.drawArc(0, getHeight()/2, getWidth(), 2*getHeight(),
				  360,180);
		
		double x = Math.cos(Math.toRadians(this.angle));
		x = -1*x;
		int width = getWidth()/2;
		int toX = (int)(width + width*x);
		
		double y = Math.sin(Math.toRadians(this.angle));
		int toY = (int)(getHeight()-2 - getHeight()*y);
		
		g.drawLine(getWidth()/2, getHeight()-2, toX, toY);
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(100,100);
	}
	
	public Dimension getMaximumSize(){
		int height = super.getMaximumSize().height;
		return new Dimension(height,height);
	}
	
	public Dimension getMinimumSize(){
		int height = super.getMinimumSize().height;
		return new Dimension(height,height);
	}
	
	public Dimension getSize(){
		int height = super.getSize().height;
		return new Dimension(height, height);
	}
	
	
}

