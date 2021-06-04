//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//starts the game. Defines window size

package platformer;


public class Launcher {

	public static void main(String[] args){
		Game game = new Game("CS240 Project", 800, 600);
		game.start();
	}
	
}
