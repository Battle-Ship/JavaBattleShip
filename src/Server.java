import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;   
    
    public Server(String ipAddress) throws Exception {
        if (ipAddress != null && !ipAddress.isEmpty()) 
          this.server = new ServerSocket(2000, 1, InetAddress.getByName(ipAddress));
        else 
          this.server = new ServerSocket(2000, 1, InetAddress.getLocalHost());
    }
    
	private void listen() throws Exception {
    	Socket socketP1 = server.accept();
    	System.out.println("Player1 connected");
    	Socket socketP2 = server.accept();
    	System.out.println("Player2 connected");
    	
    	Player player1 = new Player(socketP1);
    	Player player2 = new Player(socketP2);
    	player1.start();
    	player2.start();
    	player1.join();
    	player2.join();
    	player1.setOpponent(player2);
    	player2.setOpponent(player1);
    	BattleShipGame game = new BattleShipGame(player1, player2);
    	game.start();
    }
    
    public InetAddress getSocketAddress() {
        return this.server.getInetAddress();
    }
    
    
    public int getPort() {
        return this.server.getLocalPort();
    }
    
    public static void main(String[] args) throws Exception {
       Server app = new Server("0.0.0.0");
        System.out.println("\r\nRunning Server: " + 
                "Host=" + app.getSocketAddress().getHostAddress() + 
                " Port=" + app.getPort());
         
        app.listen();
    }
}
