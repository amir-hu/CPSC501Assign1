/**
* @version April 11 2017
* @author Group26
*/


package logic;
import gui.*; //import all the types contained in gui package
import logic.*; //import all the types contained in logic package
import java.util.Random;


/**
 * The class Obstacle is the class that generates the five obstacles in each level of the game.
 * It generates the location of the obstacles randomly but also makes sure
 * they are seprated from each other by a certain distance.
 * To use this class, we make a call in the Main class.
 * It works together with the GUI class
 * to make sure the game has complete functionality, and has the correct location of the player and obstacles.
 * This class is also called in Player class.
 */
public class Obstacle{




  public boolean obstacleInteraction(){
      Player get = new Player();
      int playerLength = get.getplayerY();
      int playerHeight = get.getplayerX();
      int playerScore = get.getPlayerScore();
      boolean hit = false;

      /**
      * Hit detection for all obstacles
      * Simply checks if the players coordinates are the same as the obstacles coordinates
      */
      // if(playerHeight >= tri1-40 &&  playerHeight <= tri1+40 && playerLength >=550) {
      //   hit = true;
      // }
      // if(playerHeight >= tri2-40 &&  playerHeight <= tri2+40 && playerLength >=550){
      //   hit = true;
      // }
      // if(playerHeight >= tri3-40 &&  playerHeight <= tri3+40 && playerLength >=550){
      //   hit = true;
      // }
      // if(playerHeight >= tri4-40 &&  playerHeight <= tri4+40 && playerLength >=550){
      //   hit = true;
      // }
      // if(playerHeight >= tri5-40 &&  playerHeight <= tri5+40 && playerLength >=550){
      //   hit = true;
      // }
      return hit;
    }

}
