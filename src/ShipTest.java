



import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



class ShipTest {

	Field field;

	@Test
	void testShipOutOfBounds() {
		field = new Field();
		// Testing a legit ship

		Ship ship = new Ship(0, 0, 4, 0);

		if (ship.isOutOfField(0, field.getField().length - 1)) {
			fail("Ship is actually inside the field");
		}

		// ship is vertical and flots out trough the bottom
		for (int r = 7; r < 11; r++) {
			Ship ship2 = new Ship(r, 7, 4, 1);
			if (!(ship2.isOutOfField(0, field.getField().length - 1)))
				fail("Ship is actually inside the field");
		}

		// ship is horizontal and floats away to the right
		for (int c = 7; c < 11; c++) {
			Ship ship3 = new Ship(7, c, 4, 0);
			if (!(ship3.isOutOfField(0, field.getField().length - 1)))
				fail("Ship is actually inside the field");
		}
	}

	@Test
	void testShipsOverlaping() {
		Ship ship4 = new Ship(2, 2, 4, 0);
		Ship ship5 = new Ship(2, 2, 3, 1);
		if (!ship4.isOverlayOrTouch(ship5))
			fail("Ships is actually overlapping");

	}

	@Test
	void testCheckHit() {
		Ship ship6 = new Ship(2, 2, 4, 0);
		Shot shot = new Shot(2, 2);
		ship6.checkHit(shot);
		ArrayList<Cell> cells = ship6.getCells();
		int timesOfHit = 0;
		for (Cell cell : cells) {
			if (!cell.isAlive()) {
				timesOfHit++;
			}
		}
		if (timesOfHit != 1) {
			fail("Ship is actually is shot");
		}
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
}
