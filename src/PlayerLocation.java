import java.util.ArrayList;
import java.util.Scanner;

public class PlayerLocation extends Field implements Location{

	private final int[] PATTERN = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1}; // pattern for ships
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	
	public PlayerLocation() {
		// TODO Auto-generated constructor stub
		super();		
		setShips();
	}
	
	// Generates locations for ships from user input
	public void setShips(){
		System.out.println("Locate on the field 10 ships");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		showField();
		Ship ship;
		int x, y, position;
		for(int size : PATTERN){
			do{
				System.out.printf("Locate on the field ship with size %d.\n", size);
				System.out.print("Row: ");
				x = input.nextInt() - 1;
				System.out.print("Column: ");
				y = input.nextInt() - 1;
				System.out.print("Position (0 - horizontal, 1 - vertical): ");
				position = input.nextInt();
				
				ship = new Ship(x, y, size, position);
				if(ship.isOutOfField(0, 10))
					System.out.println("Ship is out of field");
				else if(isOverlayOrTouch(ship))
					System.out.println("Ship overlays or touches other ship");
			}while(ship.isOutOfField(0, 10) || this.isOverlayOrTouch(ship));
			ships.add(ship);
			System.out.println(ship.toString());
	        putShip(ship);
	        showField();
		}
	}
	
	boolean isOverlayOrTouch(Ship ctrlShip) {
		for (Ship ship : ships) 
			if (ship.isOverlayOrTouch(ctrlShip)) 
				return true;
	    return false;
	}
	
	// Put ship in appropriate place
	public void putShip(Ship ship){
		int shipX = ship.getRow();
		int shipY = ship.getColumn();
		int length = ship.getLength();
		int positionY = (ship.getPosition() == 1)?  0 : 1;
		int positionX = ship.getPosition();
		for (int i = 0; i < length; i++)
           field[shipX + i * positionX][shipY + i * positionY] = 's';
	}
	
	// Mark the cell in a field with a hit-mark
	public void hitMark(int[] shot){
		int shotX = shot[0];
		int shotY = shot[1];
		field[shotX][shotY] = 'X';
	}
	
	public static void main(String[] args){
		ComputerLocation field = new ComputerLocation();
		field.setField();
		field.setShips();
		field.showField();
	}

	@Override
	public boolean hasShips() {
		// TODO Auto-generated method stub
		return false;
	}

}
