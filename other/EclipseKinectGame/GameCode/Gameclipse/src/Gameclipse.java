
/**
 * This is the sample code to step through using Eclipse and Kinect
 * @author Stephan Kšhler
 *
 */
public class Gameclipse {

	/**
	 * This function should be stepped over.
	 */
	public static void stepOver() {
		//This doesn't matter
		System.out.println("Welcome to Gameclipse");
		System.out.println("This is great!");
	}
	
	/**
	 * This function should be stepped into and afterwards the debug should be resumed.
	 * @return a
	 */
	public static void stepInto() {
		resume();
	}
	
	/**
	 * This function is just named to be resumed.
	 */
	public static void resume() {
		System.out.println("I really like Kinect and Eclipse :)");
	}
	
	public static void main(String[] args) {
		stepOver();
		stepInto();
		System.out.println("And you did a great job with the game.");
	}
	
}
