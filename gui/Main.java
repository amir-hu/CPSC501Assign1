/**
 * @version April 11 2017
 * @author Group26
 * @see Reference: http://stackoverflow.com/questions/20844144/how-do-i-make-a-rectangle-move-across-the-screen-with-key-bindings
 */

package gui;
import gui.*; //import all types contained in gui package
import logic.*; //import all types contained in logic package

/**
 * The class Main is the connector of the two basic functionalities of the game,
 * the graphic user interface(GUI) and the logic.
 * We run the game by calling this class.
 * To use this class, print "java gui/Main" in the console. After that,
 * the window will pop up and the game will start.
 */
public class Main{
  public static void main(String[] args) {
    Obstacle begin = new Obstacle();
    begin.drawspike();
    GUI start = new GUI();
    start.move();
  }
}
