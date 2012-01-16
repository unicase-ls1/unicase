package de.tum.in.oose.bumpers;

import java.applet.Applet;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

import de.tum.in.oose.bumpers.cars.Car;
import de.tum.in.oose.bumpers.cars.UserCar;
import de.tum.in.oose.bumpers.cars.FastCar;
import de.tum.in.oose.bumpers.cars.SlowCar;
import de.tum.in.oose.bumpers.cars.instruments.SpeedController;
import de.tum.in.oose.bumpers.control.Referee;
import de.tum.in.oose.bumpers.ui.Game;

public class Start {
	
	public static void main(String[] args) {
		
		try {
			Car.DEFAULT_IMAGE = loadImage("FastCar.gif");
			UserCar.DEFAULT_IMAGE = loadImage("A-Klasse.gif");
			FastCar.DEFAULT_FAST_CAR_IMAGE = loadImage("SLK.gif");
			SlowCar.DEFAULT_SLOW_CAR_IMAGE = loadImage("Kaefer.gif");
			SpeedController.UP = loadImage("up.gif");
			SpeedController.DOWN = loadImage("down.gif");
			Referee.MUSIC = Applet.newAudioClip(Start.class.getResource("Music.au"));
			Referee.BANG = Applet.newAudioClip(Start.class.getResource("Bang.au"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		
		
		Game bumperWindow = new Game();
		bumperWindow.pack();
		bumperWindow.setVisible(true);
	}
	
	private static Image loadImage(String name) throws Exception {
		URL url = Start.class.getResource(name);
		MediaTracker m = new MediaTracker(new JPanel());
		Image img = Toolkit.getDefaultToolkit().getImage(url);
		m.addImage(img, 0);
		m.waitForAll();
		return img;
	}
	
}


