



import static org.junit.Assert.*;

import org.junit.Test;

class ShotTest {
	
 
	@Test
	void testShot() {
	Shot shot = new Shot (5, 3);
	
	assertEquals (5, shot.getColumn());	
	assertEquals (3, shot.getRow());
	}

}
