package application;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	PlayerLocation playerField;
	Field opponentField;
	
	public Player() {
		// TODO Auto-generated constructor stub
		playerField = new PlayerLocation();
		opponentField = new Field();
	}
	
	public void makeShot(Player opponent) {
		int[] shotCoordinates = this.shoot();
		Shot shot = new Shot(shotCoordinates[0], shotCoordinates[1]);
		this.checkShot(shot, opponent);
	}
	
	// Takes a user input and generate shot object (x, y)
	public int[] shoot(){
		int[] shot = new int[2];
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Column: ");
		shot[0] = input.nextInt() - 1;
		System.out.print("Row: ");
		shot[1] = input.nextInt() - 1;
		
		return shot;
	}
	
	public void checkShot(Shot shot, Player opponent) {
		ArrayList<Ship> ships = opponent.playerField.getShips();
		for(Ship ship : ships) {
			if(ship.checkHit(shot) == 1) {
				System.out.println("Hit");
				opponentField.hitMark(shot);
				opponent.playerField.hitMark(shot);
				return;
			}
			else if(ship.checkHit(shot) == -1){
				System.out.println("Already hitted");
				return;
			}
		}
		System.out.println("Miss");
		opponentField.missMark(shot);
		opponent.playerField.missMark(shot);
	}
	
	// Check if player hitted or missed
	/*public void checkShot(Player player2){
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
	}*/
}
