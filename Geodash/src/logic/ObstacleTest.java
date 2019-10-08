package logic;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObstacleTest  {



  //to check if the player is not near a spike he does not get hit
  @Test
  public void playeratStart() {
	  Player player = new Player();
	  player.setplayerX(0);
	  player.setplayerY(550);
    Spike test = new Spike(); 
    test.drawspike();
    for (int i = 0;i < 5;i++) {
      int offset = 100 + (300 * i);
      test.setSpike(100 + offset,i);
    }
    boolean hit = test.hitDetection();
    assertEquals(hit, false);
  }
  
  
  //placed right on the first spike
  @Test
  public void playerHitFirstSpike() {
	  Player player = new Player();
	    Spike test = new Spike();
	    player.setplayerX(190);
	    player.setplayerY(550); 
	    test.drawspike(); 
	    for (int i = 0;i < 5;i++) {
	      int offset = 100 + (300 * i);
	      test.setSpike(100 + offset,i);
	    }
	    boolean hit = test.hitDetection();
	    assertEquals(hit, true);
	  
  }
  
  //jumping right over the first spike 
  @Test 
  public void jumpingOverSpike() {
	  Player player = new Player();
	    Spike test = new Spike();
	    player.setplayerY(500);
	    test.drawspike(); 
	    for (int i = 0;i < 5;i++) {
	      int offset = 100 + (300 * i);
	      test.setSpike(100 + offset,i);
	    }
	    boolean hit = test.hitDetection();
	    assertEquals(hit, false);
	  
  }
}
