import java.util.ArrayList;
import java.util.Scanner;

public class PlayerLocation extends Field implements Location{

	private final int[] PATTERN = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	
	public PlayerLocation() {
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
		int column, row, position;
		for(int size : PATTERN){
			do{
				System.out.printf("Locate on the field ship with size %d.\n", size);
				System.out.print("Column: ");
				column = input.nextInt() - 1;
				while (!(column <10 && column > 0)) {
					System.out.println("Wrong Column");
					System.out.println ("Choose correct Column from 1 to 10.");
					System.out.print("Column: ");
					column = input.nextInt();
				continue;
				}
				
				System.out.print("Row: ");
				row = input.nextInt() - 1;
				while (!(row <10 && row > 0)) {
					System.out.println("Wrong Row");
					System.out.println ("Choose correct Row from 1 to 10.");
					System.out.print("Row: ");
					row = input.nextInt();
				continue;
				}
				
				System.out.print("Position (0 - horizontal, 1 - vertical): ");
				position = input.nextInt();
				while (position !=0 && position !=1) {
					System.out.println("Wrong position");
					System.out.print("Choose the correct position (0 - horizontal, 1 - vertical): ");
					position = input.nextInt();
				continue;
			}
				ship = new Ship(row, column, size, position);
				if(ship.isOutOfField(0, 9))
					System.out.println("Ship is out of field");
				else if(isOverlayOrTouch(ship))
					System.out.println("Ship overlays or touches other ship");
			}while(ship.isOutOfField(0, field.length) || this.isOverlayOrTouch(ship));
			ships.add(ship);
			//System.out.println(ship.toString());
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
	public void hitMark(Shot shot){
		field[shot.getRow()][shot.getColumn()] = 'X';
	}
	
	public static void main(String[] args){
		ComputerLocation field = new ComputerLocation();
		field.setField();
		field.setShips();
		field.showField();
	}
	
	public ArrayList<Ship> getShips(){
		return ships;
	}

	@Override
	public boolean hasShips() {
		for(Ship ship : ships) {
			if(ship.isAlive())
				return true;
		}
		return false;
	}
}
