import java.io.IOException;

public class BattleShipGame {
	
	Location field;
	Player player;
	int attempts;

	public BattleShipGame(Location field, Player player){
		this.field = field;
		this.player = player;
	}
	
	// Starts the game
	public void start() throws IOException{
		System.out.println("Game start!!!");
		field.showField();
		while(field.hasShips()){
			attempts++;
			player.checkShot(field);
			field.showField();
		}
		System.out.println("Game Over!!!");
		field.showField();
		System.out.printf("You've made %d attemts!", attempts);
	}
	
	public static void main(String[] args) throws IOException{
		//ComputerLocation field = new ComputerLocation();
		PlayerLocation field = new PlayerLocation();
		Player player = new Player();
		BattleShipGame game = new BattleShipGame(field, player);
		game.start();
	}
}
