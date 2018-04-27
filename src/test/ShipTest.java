package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import application.Field;
import application.Ship;

class ShipTest {

	Field field;
	
	@Before
	public void setUp() {
		field = new Field();
	}
	
	@Test
	void testShipOutOfBounds() {
		// Testing a legit ship
		Ship ship = new Ship(0, 0, 4, 0);
		if(ship.isOutOfField(0, field.getField().length - 1)) {
			fail("Ship is actually inside the field");
		}
		
		// testing ship partially over left side
		
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
