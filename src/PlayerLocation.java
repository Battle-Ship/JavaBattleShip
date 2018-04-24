import java.util.Scanner;

public class PlayerLocation extends Field implements Location{

	int[][] ships;
	int shipsAmount;
	
	public PlayerLocation() {
		// TODO Auto-generated constructor stub
		super();
		ships = new int[3][2];
		
		setShips();
	}
	
	public boolean hasShips(){
		if(shipsAmount > 0)
			return true;
		return false;
	}
	
	// Generates locations for ships from user input
	public void setShips(){
		System.out.println("Locate on the field 3 ships");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		showField();
		for(int shipNo = 0; shipNo < 3; shipNo++){
			System.out.printf("Locate on the field ship No%d.\n", shipNo + 1);
			System.out.print("Row: ");
			ships[shipNo][0] = input.nextInt() - 1;
			System.out.print("Column: Input ");
			ships[shipNo][1] = input.nextInt() - 1;
			
			// Checks if this cell is already taken
	        // If cell is already taken, generate other location
	        for(int last=0 ; last < shipNo ; last++){
	        	while((ships[shipNo][0] == ships[last][0]) && (ships[shipNo][1] == ships[last][1])){
	        		System.out.printf("Cannot place ship in cell [%d,%d], it is already used. Try other cell.\n", ships[shipNo][0], ships[shipNo][1]);
	    			System.out.print("Row: ");
	    			ships[shipNo][0] = input.nextInt() - 1;
	    			System.out.print("Column: ");
	    			ships[shipNo][1] = input.nextInt() - 1;
	            }
	        }
	        shipsAmount++;
	        putShip(ships[shipNo]);
	        showField();
		}
	}
	
	// Put ship in appropriate place
	public void putShip(int[] ship){
		int shipX = ship[0];
		int shipY = ship[1];
		field[shipX][shipY] = 's';
	}
	
	// Mark the cell in a field with a hit-mark
	public void hitMark(int[] shot){
		int shotX = shot[0];
		int shotY = shot[1];
		field[shotX][shotY] = 'X';
		shipsAmount--;
	}
	
	public static void main(String[] args){
		ComputerLocation field = new ComputerLocation();
		field.setField();
		field.setShips();
		field.showField();
	}

}
