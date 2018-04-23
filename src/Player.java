import java.util.Scanner;

public class Player {
	
	PlayerLocation playerField;
	Field opponentField;
	
	public Player() {
		// TODO Auto-generated constructor stub
		playerField = new PlayerLocation();
		opponentField = new Field();
	}
	
	// Takes a user input and generate shot object (x, y)
	public int[] shoot(){
		int[] shot = new int[2];
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Row: ");
		shot[0] = input.nextInt() - 1;
		System.out.print("Column: ");
		shot[1] = input.nextInt() - 1;
		
		return shot;
	}
	
	// Check if player hitted or missed
	public void checkShot(Player player2){
		int[] shot = shoot();
		int shotX = shot[0];
		int shotY = shot[1];
		if(player2.playerField.getField()[shotX][shotY] == 's'){
			System.out.println("Hit");
			opponentField.hitMark(shot);
			player2.playerField.hitMark(shot);
		}
		else if(player2.playerField.getField()[shotX][shotY] == '0'){
			System.out.println("Miss");
			opponentField.missMark(shot);
			player2.playerField.missMark(shot);
		}
		else{
			System.out.println("Already hitted");
		}
	}
}
