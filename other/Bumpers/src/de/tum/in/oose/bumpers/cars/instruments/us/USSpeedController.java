package de.tum.in.oose.bumpers.cars.instruments.us;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import de.tum.in.oose.bumpers.cars.UserCar;
import de.tum.in.oose.bumpers.cars.instruments.SpeedController;

public class USSpeedController extends SpeedController implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton up;
	
	private JButton down;
	
	private JLabel label = new JLabel("Speed control", JLabel.LEFT);
	
	public USSpeedController(UserCar theCar){
		super(theCar);
		
		setLayout(new BorderLayout());
		if(UP != null && DOWN != null){
			up = new JButton(new ImageIcon(UP));
			down = new JButton(new ImageIcon(DOWN));
		}else{
			up = new JButton("up");
			down = new JButton("down");
		}
		
		up.addActionListener(this);
		down.addActionListener(this);
		
		add(label, BorderLayout.WEST);
		JToolBar buttonBar = new JToolBar();
		buttonBar.setFloatable(false);
		buttonBar.add(up);
		buttonBar.add(down);
		add(buttonBar, BorderLayout.CENTER);
		enableButtons();
	}
	
	private void enableButtons() {
		if(this.theCar.getSpeed() < theCar.MAX_SPEED){
			up.setEnabled(true);
		}else{
			up.setEnabled(false);
		}
		
		if(this.theCar.getSpeed() > theCar.MIN_SPEED){
			down.setEnabled(true);
		}else{
			down.setEnabled(false);
		}
	}
	
	public void updateInstrument() {
		enableButtons();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(up)){
			theCar.incrementSpeed();
			theCar.notifyInstruments();
			
		}else{
			theCar.decrementSpeed();
			theCar.notifyInstruments();
		}
	}
}

