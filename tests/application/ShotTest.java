package application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.Shot;

public class ShotTest {

	@Test
	public void testShot() {
		Shot shot = new Shot(5, 3);

		assertEquals(5, shot.getColumn());
		assertEquals(3, shot.getRow());
	}

}
