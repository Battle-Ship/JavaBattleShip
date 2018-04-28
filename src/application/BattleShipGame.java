package application;

import java.io.IOException;

public class BattleShipGame {
	
	private Player player1;
	private Player player2;
	private int attempts;

	public BattleShipGame(Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
	}
	
	// Starts the game
	public void start() throws IOException, ClassNotFoundException, InterruptedException{
		String lastPlayer = "Noone";
		System.out.println("Game start!!!");
		sendMessage("\nGame Start!!!");
		while (player1.getPlayerField().hasShips() && player2.getPlayerField().hasShips()){
			if(attempts % 2 == 0){
				player2.sendMessage("\nOpponent is shooting");
				System.out.println("Player1 goes: ");
				player1.makeShot();
				Shot shot = (Shot) player1.readObject();
				int result = player1.checkShot(shot);
				if(result == -2){
					player2.sendMessage("\nOpponent hitted!");
					player2.markOpponentShot("HIT", shot);
				}
				else if(result == 0){
					player2.sendMessage("\nOpponent missed!");
					player2.markOpponentShot("MISS", shot);
				}
				else if(result == -1)
					player2.sendMessage("\nOpponent is idiot! He shooted where he already has shooted!");
				else {
					player2.sendMessage("\nOpponent sunk your ship with size " + result + "!");
					player1.sendMessage("\nYou've sunk opponent ship with size " + result + "!\n");
					player2.markOpponentShot("DESTROY", shot);
				}
				player1.writeField();
				System.out.println("***********************************************");
				lastPlayer = player1.getNick();
			}
			else{
				player1.sendMessage("\nOpponent is shooting");
				System.out.println("Player2 goes: ");
				player2.makeShot();
				Shot shot = (Shot) player2.readObject();
				int result = player2.checkShot(shot);
				if(result == -2){
					player1.sendMessage("\nOpponent hitted!");
					player1.markOpponentShot("HIT", shot);
				}
				else if(result == 0){
					player1.sendMessage("\nOpponent missed!");
					player1.markOpponentShot("MISS", shot);
				}
				else if(result == -1)
					player1.sendMessage("\nOpponent is idiot! He shooted where he already has shooted!");
				else {
					player1.sendMessage("\nOpponent sunk your ship with size " + result + "!");
					player2.sendMessage("\nYou've sunk opponent ship with size " + result + "!\n");
					player1.markOpponentShot("DESTROY", shot);
				}
				player2.writeField();
				System.out.println("***********************************************");
				lastPlayer = player2.getNick();
			}
			attempts++;
		}
		sendMessage("\n*******************************************************************************");
		sendMessage("\nGame Over!!!\nWinner: " + lastPlayer);
		player1.writeField();
		player2.writeField();
		sendMessage("\nWere made " + Integer.toString(attempts) + " shots!\n");
		
		System.out.println("Game Over!!!");
		System.out.println("Winner: " + lastPlayer);
		System.out.printf("They've made %d attemts!", attempts);
		
		finishGame();
	}
	
	public void sendMessage(String message) throws IOException {
		player1.sendMessage(message);
		player2.sendMessage(message);
	}
	
	public void finishGame() throws IOException {
		player1.finishGame();
		player2.finishGame();
	}
}
