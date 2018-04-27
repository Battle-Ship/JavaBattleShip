package application;
import java.io.IOException;

public class BattleShipGame {
	
	Player player1;
	Player player2;
	int attempts;

	public BattleShipGame(Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
	}
	
	// Starts the game
	public void start() throws IOException{
		String lastPlayer = "Noone";
		System.out.println("Game start!!!");
		while(player1.playerField.hasShips() && player2.playerField.hasShips()){
			
			if(attempts % 2 == 0){
				System.out.println("Player1 goes: ");
				player1.opponentField.showField();
				player1.makeShot(player2);
				player1.opponentField.showField();
				System.out.println("***********************************************");
				lastPlayer = "Player1";
			}
			else{
				System.out.println("Player2 goes: ");
				player2.opponentField.showField();
				player2.makeShot(player1);
				player2.opponentField.showField();
				System.out.println("***********************************************");
				lastPlayer = "Player2";
			}
			attempts++;
		}
		System.out.println("Game Over!!!");
		System.out.println("Winner: " + lastPlayer);
		System.out.printf("You've made %d attemts!", attempts);
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("Player1 goes: ");
		Player player1 = new Player();
		System.out.println("***********************************************");
		System.out.println("Player2 goes: ");
		Player player2 = new Player();
		System.out.println("***********************************************");
		BattleShipGame game = new BattleShipGame(player1, player2);
		game.start();
	}
}
