package de.tum.in.oose.bumpers.cars.instruments.us;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.tum.in.oose.bumpers.cars.UserCar;
import de.tum.in.oose.bumpers.cars.instruments.Body;

public class USBody extends Body{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image drivenCarImage;
	private JPanel theIcon;
	private JLabel theText = new JLabel("Your car");;
	
	public USBody(UserCar theCar){
		super(theCar);
		this.drivenCarImage = theCar.getBody();
		setLayout(new BorderLayout());
		
		theIcon = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g){
				super.paint(g);
				int yPosition = USBody.this.getSize().height/2;
				yPosition = yPosition-USBody.this.theCar.getSize().height/2;
				g.drawImage(drivenCarImage,
							0,
							yPosition,
							USBody.this.theCar.getSize().width,
							USBody.this.theCar.getSize().height,
							null);
			}
		};
		add(theIcon, BorderLayout.CENTER);
		add(theText, BorderLayout.EAST);
	}
	
	
	public void updateInstrument() {
		if(!theCar.getBody().equals(this.drivenCarImage)){
			this.drivenCarImage = theCar.getBody();
			theIcon.repaint();
		}
	}
}

