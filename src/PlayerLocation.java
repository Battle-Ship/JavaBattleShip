import java.util.Scanner;

public class PlayerLocation implements Location{

	char[][] field = new char[5][5];
	int[][] ships = new int[3][2];
	int shipsAmount;
	
	public PlayerLocation() {
		// TODO Auto-generated constructor stub
		setField();
		setShips();
	}
	
	public boolean hasShips(){
		if(shipsAmount > 0)
			return true;
		return false;
	}
	
	// Fills the field with '0'
	public void setField(){
		for(int row = 0; row < 5; row++){
			for(int column = 0; column < 5; column++){
				field[row][column] = '0';
			}
		}
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
			System.out.print("Column: ");
			ships[shipNo][1] = input.nextInt() - 1;
			
			// Checks if this cell is already taken
	        // If cell is already taken, generate other location
	        for(int last=0 ; last < shipNo ; last++){
	        	while((ships[shipNo][0] == ships[last][0]) && (ships[shipNo][1] == ships[last][1])){
	        		System.out.printf("Cannot place ship in cell [%d,%d], it is already used. Try other cell.", ships[shipNo][0], ships[shipNo][1]);
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
	
	// Mark the cell in a field with a miss-mark
	public void missMark(int[] shot){
		int shotX = shot[0];
		int shotY = shot[1];
		field[shotX][shotY] = '*';
	}
	
	// Prints the field
	public void showField(){
		for(char[] row : field){
			for(char cell : row){
				System.out.print("\t" + cell);
			}
			System.out.println();
		}
	}
	
	public char[][] getField(){
		return field;
	}
	
	public static void main(String[] args){
		ComputerLocation field = new ComputerLocation();
		field.setField();
		field.setShips();
		field.showField();
	}

}
