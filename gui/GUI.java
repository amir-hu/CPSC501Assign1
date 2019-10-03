/**
 * @version April 11 2017
 * @author Group26
 * @see Reference: http://stackoverflow.com/questions/20844144/how-do-i-make-a-rectangle-move-across-the-screen-with-key-bindings
 */

package gui;
import gui.*; //import all the types contained in gui package
import logic.*; //import all the types contained in logic package
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The class GUI is one of the two graphic user interface classes in the game
 * The functionality of this class is having two timers that ensure the game
 * keeps on going and the world and the player get repainted when any action event
 * occurs.
 * The window size of the game is also initialized in this class.
 * This class is only used for painting.
 * To use this class, we make a call in Main class.
 */
public class GUI extends JFrame {
	private Timer timer = new Timer(25,null);
	private Timer gravityActionTimer = new Timer(100,null); //Jumping action
	public static final int WINDOW_LENGTH = 1500;
	public static final int WINDOW_HEIGHT = 720;
	Player player = new Player();
	World drawWorld = new World();


	/**
	 * Preforms this function when the space bar is entered.
	 * Before the acton is preformed, it checks to see if the player is on the ground or not.
	 * This ensures no double jump will be preformed and that the player does not go off the map.
	 * Once the requisetes have been completed the coordinates will move the player accordingly
	 * Once the coordinates have been reajusted then the jump will be applied in rejump
	 */
	private void initialize(){
		add(drawWorld);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(WINDOW_LENGTH,WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	Action spaceAction = new AbstractAction(){
		/**
		 * spaceAction does the jumping action for the player
		 * @param e the parameter ActionEvent takes
		 */
		public void actionPerformed(ActionEvent e) {
			player.playerJump();
			drawWorld.repaint();
		}
	};

	/**
	 * Gravity function is set on a timer gravityActionTimer
	 * This action ensures that the player will always be on the ground
	 * This is also meant to serve as the falling sectiojn of the jump
	 */
	ActionListener gravityAction = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			player.playerDown();
			drawWorld.repaint();
		}
	};

	/**
	 * A shortcut when the r button is cliked simply sets the player back to the beginning
	 * @param e the parameter ActionEvent takes
	 */
	Action reset = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			player.playerReset();
			drawWorld.repaint();
		}
	};

	/**
	 * A shortcut when the b button is cliked simply starts the game
	 * @param e the parameter ActionEvent takes
	 */
	Action begin = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			timer.start();
			gravityActionTimer.start();
		}
	};

	/**
	 * A shortcut when the q button is cliked simply closes the window and quit the game
	 * @param e the parameter ActionEvent takes
	 */
	Action quit = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	};

	/**
	 * A shortcut when the r button is cliked simply reload the game
	 * with the existing score stored in the text file
	 * @param e the parameter ActionEvent takes
	 */
	Action load = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			player.reading();
			drawWorld.repaint();
		}
	};

	/**
	 * A shortcut when the p button is cliked simply pauses the game
	 * @param e the parameter ActionEvent takes
	 */
	Action pause = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			timer.stop();
			gravityActionTimer.stop();
		}
	};

	/**
	 * A shortcut when the s button is cliked simply saves the current score to the text file
	 * @param e the parameter ActionEvent takes
	 */
	Action save = new AbstractAction(){
		public void actionPerformed(ActionEvent e){
			player.writing();
		}
	};

	/**
	 * This listener is set on a timer so it runs automatically
	 * it checks for 2 things the first will be if the player has left the scren if that is the case the You win window will
	 * pop up and display the victory message
	 * The other checks to see if hitDetection retrns true and if it does it will reset the playerY
	 * Otherwise the player will continue going straight
	 */
	ActionListener straight = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			player.playerStraight();
			drawWorld.repaint();
		}
	};


	protected void move() {
		initialize();
		InputMap inputMap = drawWorld.getInputMap();
		ActionMap actionMap = drawWorld.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke("SPACE"), "spaceAction");
		actionMap.put("spaceAction", spaceAction);
		inputMap.put(KeyStroke.getKeyStroke("R"), "reset");
		actionMap.put("reset", reset);
		inputMap.put(KeyStroke.getKeyStroke("S"), "save");
		actionMap.put("save", save);
		inputMap.put(KeyStroke.getKeyStroke("B"), "begin");
		actionMap.put("begin", begin);
		inputMap.put(KeyStroke.getKeyStroke("L"), "load");
		actionMap.put("load", load);
		inputMap.put(KeyStroke.getKeyStroke("P"), "pause");
		actionMap.put("pause", pause);
		inputMap.put(KeyStroke.getKeyStroke("Q"), "quit");
		actionMap.put("quit", quit);
		timer =  new Timer(25,straight);
		gravityActionTimer = new Timer(50,gravityAction);
	}
}
