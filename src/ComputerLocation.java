import java.util.Random;

public class ComputerLocation extends Field implements Location{
	
	int[][] ships = new int[3][2];
	int shipsAmount;
	
	public ComputerLocation() {
		// TODO Auto-generated constructor stub
		super();
		setShips();
	}
	
	public boolean hasShips(){
		if(shipsAmount > 0)
			return true;
		return false;
	}
	
	// Randomly generates locations for ships
	public void setShips(){
		 Random random = new Random();
	     for(int shipNo = 0 ; shipNo < 3 ; shipNo++){
			 ships[shipNo][0]=random.nextInt(5);
	         ships[shipNo][1]=random.nextInt(5);
	         
	        
	         // Checks if this cell is already taken
	         // If cell is already taken, generate other location
	         for(int last=0 ; last < shipNo ; last++){
	        	 while((ships[shipNo][0] == ships[last][0]) && (ships[shipNo][1] == ships[last][1])){
	        		 ships[shipNo][0]=random.nextInt(5);
	                 ships[shipNo][1]=random.nextInt(5);
	             }
	         }
	         shipsAmount++;
	         putShip(ships[shipNo]);
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
