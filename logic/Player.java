/**
* @version April 11 2017
* @author Group26
*/


package logic;
import gui.*; //import all the types contained in gui package
import logic.*; //import all the types contained in logic package
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
/**
* The class Player is the main class of the logic part of this game.
* It connects the Obstacle class by calling it.
* It is being used to calculte the player's location when any action event is performed
* and to get the score of the player.
* This class is being called in GUI class - which repaints the map and player based on the players location.
*/
public class Player{
  private static int playerX = 0;
  private static int playerY = 550;
  private static int playerScore = 0;


  /**
  *getter method for playerScore
  *@return playerScore the current player score
  */
  public int getPlayerScore(){
    return playerScore;
  }

  /**
  *getter method for playerY
  *@return playerY the height of the player relative to the main platform
  */
  public int getplayerY(){
    return playerY;
  }

  /**
  *getter method for playerX
  *@return playerX the height of the player relative to the main platform
  */
  public int getplayerX(){
    return playerX;
  }

  /**
  *setter method for playerX
  *sets playerX to xValue
  */
  public void setplayerX(int xValue){
    this.playerX = xValue;
  }

  /**
  *setter method for playerY
  *sets playerY to yValue
  */
  public void setplayerY(int yValue){
    this.playerY = yValue;
  }

  public void playerJump(){
    if(playerY == 550){
      playerY -= 50;
      playerX += 80;
    }
  }

  public void playerReset(){
    playerX = 0;
    playerScore = 0;
  }

  public void playerDown(){
    if(playerY < 550){
      playerY += 20;
      playerX +=20;
    }

    if(playerY > 550){
      playerY -= 10;
    }
  }

  public void playerStraight(){
    Spike create = new Spike();
    if(create.obstacleInteraction()){
      playerX = 0;
      playerScore = 0;
    }
    if (playerX >= 1350) {
      create.drawspike();
      playerX = 0;
    }
    else {
      playerX += 5;
      playerScore ++;
    }
  }

  public void writing() {
    try {
        File highScores = new File("Scores.txt");
        FileOutputStream is = new FileOutputStream(highScores);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        Writer scores = new BufferedWriter(osw);
        scores.write("Score: " + playerScore);
        scores.close();
    } catch (IOException e) {
        System.err.println("Problem writing to the file Scores.txt");
    }
  }

  public void reading(){
    String fileName = "Scores.txt";
    Scanner inputStream = null;
    String word = null;

    try {
      inputStream = new Scanner (new File(fileName));
    }
    catch (FileNotFoundException e) {
      System.out.println("Error opening the file " + fileName);
    }

		while(inputStream.hasNextLine()) {
      String line = inputStream.nextLine();
      String[] words = line.split(" ");
      for (int index = 1; index < words.length; index++) {
        word = words[index];
      }
		}

		inputStream.close();

    try {
      playerScore = Integer.parseInt(word);
    }
    catch(NumberFormatException n){
      playerScore= 0;
    }

  }



}
