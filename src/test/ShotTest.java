package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import application.Shot;

class ShotTest {
	
 
	@Test
	void testShot() {
	Shot shot = new Shot (5, 3);
	
	assertEquals (5, shot.getColumn());	
	assertEquals (3, shot.getRow());
	}

}
