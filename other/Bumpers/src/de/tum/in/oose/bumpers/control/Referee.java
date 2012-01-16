package de.tum.in.oose.bumpers.control;

import java.applet.AudioClip;

import javax.swing.JOptionPane;

import de.tum.in.oose.bumpers.cars.Car;
import de.tum.in.oose.bumpers.cars.GameBoard;
import de.tum.in.oose.bumpers.ui.ToolBar;

public class Referee implements Runnable {
	
	public static AudioClip MUSIC;
    public static AudioClip BANG;
	private static int SLEEP_TIME = 200;
	private static Referee INSTANCE;
	private Thread theThread;
    private boolean isRunning;
    
    public String test;
	
	private CollisionStrategy collisionStrategy = new DefaultCollision();
	
	private Referee(){
		setFramesPerSecond(15);
	}
	
	
	
	public static Referee getInstance(){
		if(INSTANCE == null){
			INSTANCE = new Referee();
		}
		return INSTANCE;
	}
	
	public void initGame() {
		GameBoard.getInstance().initiate();
		ToolBar.getInstance().enableButtons();
	}
	
	public void startGame() {
		if(isRunning){ return;}
		MUSIC.loop();
		isRunning = true;
		theThread = new Thread(this);
		theThread.start();
		ToolBar.getInstance().enableButtons();
	}
	
    public void stopGame() {
		if(!isRunning){ return;}
		MUSIC.stop();
		isRunning = false;
		ToolBar.getInstance().enableButtons();
    }
	
	public void run() {
		while (isRunning) {
			try {
				Thread.sleep(SLEEP_TIME);
			}
			catch (InterruptedException e) { e.printStackTrace(); }
			moveCars();
		}
	}
	
	public void moveCars() {
		GameBoard playingField = GameBoard.getInstance();
		Car[] cars = playingField.getRobotCars();
		
		int max_x = playingField.getSize().width;
		int max_y = playingField.getSize().height;
		for (int i = 0; i < cars.length; i++) {
			cars[i].updatePosition(max_x, max_y);
		}
		playingField.getDrivenCar().updatePosition(max_x, max_y);
		playingField.repaint();
		
		
		Car drivenCar = playingField.getDrivenCar();
		for (int i = 0; i < cars.length; i++) {
			if (cars[i].isCrunched( )) {continue;}
			
			Car crashedCar = collisionStrategy.detectCollision(drivenCar, cars[i]);
			if(crashedCar != null){
				BANG.play();
				crashedCar.setCrunched();
				if(drivenCar.isCrunched()){
					stopGame();
					JOptionPane.showMessageDialog(null,
												  "You lost the game!",
												  "Information",
												  JOptionPane.INFORMATION_MESSAGE);
					initGame();
				}else{
					boolean playerWon = true;
					for (int z = 0; z < cars.length; z++) {
						playerWon = playerWon && cars[z].isCrunched();
						if(!playerWon){ break; }
					}
					if(playerWon){
						stopGame();
						JOptionPane.showMessageDialog(null,
													  "Congratulation, You win the game!",
													  "Information",
													  JOptionPane.INFORMATION_MESSAGE);
						initGame();
					}
				}
			}
		}
	}
	
	public boolean isRunning(){
		return this.isRunning;
	}
	
	
	public static int getFramesPerSecond(){
		return 1000 / SLEEP_TIME;
	}
	
	public static void setFramesPerSecond(int framesPerSecond) throws IllegalArgumentException {
		if(framesPerSecond > 0){
			SLEEP_TIME = 1000 / framesPerSecond;
		}else{
			throw new IllegalArgumentException("Frames per second must be greater than 0.");
		}
	}
	
	public void setCollisionStrategy(CollisionStrategy collisionStrategy) {
		this.collisionStrategy = collisionStrategy;
	}
	
	public CollisionStrategy getCollisionStrategy() {
		return collisionStrategy;
	}
}

