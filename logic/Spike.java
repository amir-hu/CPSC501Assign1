/**
 * @version April 11 2017
 * @author Amir Hussain
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


public class Spike extends Obstacle{

  private static int[4] spike;


  public int getSpike(int index){
    return spike[index];
  }

  public void setSpike(int value,int index){
    spike[index] = value;
  }
}
