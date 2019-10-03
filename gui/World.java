/**
* @version April 11 2017
* @author Group26
*/

package gui;
import gui.*; //import all types contained in the gui package
import logic.*; //import all types contained in the logic package
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
* The class World is one of two graphic user interface classes in the game.
* The functionality of this class is to set the background color of the game,
* and paint all obstacles and the player.
* It also displays instructions for the shortcut keys on the game screen.
* This class is only used for painting.
* We don't use this class manually.
* This class is called in GUI class automatically.
* These two classes work together to paint components of the game.
*/
public class World extends JPanel{
  private BufferedImage upwardsSpike;
  private BufferedImage player;

  /**
   * @exception IOEXception catches an exception if there is error displaying
   * the image of the objects in the game
   */
  public World() {
    try {
      upwardsSpike = ImageIO.read(new File("Spike.png"));
      player = ImageIO.read(new File("Player.png"));
    } catch (IOException e) {
        System.out.println("Error: IOException");
    }
  }

  protected void paintComponent (Graphics paint) {
    Spike grab = new Spike();
    int[] spikes = grab.getSpike();

    //It`s unknown why, but this line prevents the game from lagging.
    GUI fixLag = new GUI();
    Player get = new Player();
    int playerX = get.getplayerX();
    int playerY = get.getplayerY();
    int score = get.getPlayerScore();
    //Paint instructions for the shortcut keys on the screen.
    super.paintComponent(paint);
    paint.setColor(Color.WHITE);
    paint.drawString("SCORE: " + score, 750,100);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'B' to begin", 25,25);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'P' to pause", 25,50);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'R' to restart the level", 25,75);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'L' to reload a saved game", 25,100);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'S' to save your score", 25,125);

    paint.setColor(Color.WHITE);
    paint.drawString("Press 'Q' to exit the game", 25,150);

    //Sets background color
    this.setBackground(Color.BLACK);

    paint.drawImage(upwardsSpike, spikes[0], 560, this);
    paint.drawImage(upwardsSpike, spikes[1], 560, this);
    paint.drawImage(upwardsSpike, spikes[2], 560, this);
    paint.drawImage(upwardsSpike, spikes[3], 560, this);
    paint.drawImage(upwardsSpike, spikes[4], 560, this);

    paint.drawImage(player, playerX, playerY, this);
    paint.setColor(Color.RED);
    paint.fillRect(0,600,1900,25);
  }
}
