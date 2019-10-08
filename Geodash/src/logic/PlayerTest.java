package logic;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {

	Player play = new Player();
	Spike create = new Spike();
	public void setVaraibles(int x, int y) {
		
		play.setplayerX(x);
		play.setplayerY(y);
	}
	
	@Test
	public void playerDownTest() {
		setVaraibles(0,500);
		play.playerDown();
		assertEquals(play.getplayerY(), 520);
		assertEquals(play.getplayerX() , 20);
	}
	@Test
	public void playerjumpTest() {
		setVaraibles(0,550);
		play.playerJump();
		assertEquals(play.getplayerX(), 80);
		assertEquals(play.getplayerY(), 500);
		
	}
	@Test
	public void playerjumpTestInAir() {
		setVaraibles(0,520);
		play.playerJump();
		assertEquals(play.getplayerX(), 0);
		assertEquals(play.getplayerY(), 520);
		
	}
	
	@Test
	public void playerDownTestFloor() {
		setVaraibles(0,550);
		play.playerDown();
		assertEquals(play.getplayerY(), 550);
		assertEquals(play.getplayerX() , 0);
		
	}
	@Test
	public void playerStraightCrash() {
		
		create.drawspike(); 
		create.setSpike(300, 0);
		setVaraibles(290,550);
		play.playerStraight();
		assertEquals(play.getplayerX(),5); 
		assertEquals(play.getPlayerScore(),1); 
		
	}
	@Test
	public void playerStraightEnd() {
		
		create.drawspike();
		setVaraibles(1800,550);
		play.playerStraight();
		assertEquals(play.getplayerX(),0);
	}
	@Test
	public void playerStraightNormal() {
		create.drawspike();
		setVaraibles(0,550);
		play.playerStraight();
		assertEquals(play.getplayerX(),5);
	}
}
