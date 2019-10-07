/**
 * @version April 11 2017
 * @author Amir Hussain
 */

 package logic;
 import java.util.Random;


public class Spike extends Obstacle{

  private static int[] spike;
  private static int Spike_Size = 40;


  public int[] getSpike(){
    return spike;
  }

  public void setSpike(int value,int index){
    spike[index] = value;
  }

  public void drawspike(){
    spike = new int[5];
    Random drawspike = new Random(); 
    for (int i = 0;i < 5;i++) {
      int offset = 100 + (300 * i);
      spike[i] = drawspike.nextInt(200) + offset;
    }
  }

  protected boolean hitDetection(){
    return super.obstacleInteraction(Spike_Size);
  }


}
