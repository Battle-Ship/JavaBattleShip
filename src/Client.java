import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private PlayerLocation playerField;
    private Field opponentField;
    
    private Client(InetAddress serverAddress) throws Exception {
        this.socket = new Socket(serverAddress, 2000);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        
    }
    
    private void start() throws IOException, ClassNotFoundException {
        String command = (String) ois.readObject();
        if(command.equals("CREATE_FIELD")) {
        	@SuppressWarnings("resource")
        	Scanner input = new Scanner(System.in);
        	System.out.print("Name: ");
    		String name = input.nextLine();
    		oos.writeObject(name);
        	playerField = new PlayerLocation(); 
        	opponentField = new Field();
        	oos.writeObject(playerField);
        }
        else
        	System.out.println("Wrong 1st command");

        System.out.println("Waiting for other players...");
        while((command = (String) ois.readObject()) != null) {
        	if(command.equals("MAKE_SHOT")){
        		System.out.println("\nYour turn: ");
        		showFields();
        		@SuppressWarnings("resource")
        		Scanner input = new Scanner(System.in);
        		
        		System.out.print("Column: ");
        		int shotColumn = input.nextInt() - 1;
        		System.out.print("Row: ");
        		int shotRow = input.nextInt() - 1;
        		Shot shot = new Shot(shotColumn, shotRow);
        		oos.writeObject("SHOT");
        		oos.writeObject(shot);
        		
        		String text = (String) ois.readObject();
        		if(text.equals("HIT")) {
        			opponentField.hitMark(shot);
        		}
        		else if(text.equals("MISS"))
        			opponentField.missMark(shot);
        		else if(text.equals("DESTROY"))
        			opponentField.destroyMark(shot);
        		else 
        			System.out.println("Strange");
        	}
        	else if(command.equals("MESSAGE")) {
        		String message = (String) ois.readObject();
        		System.out.println(message);
        	}
        	else if(command.equals("FIELD")) {
        		showFields();
        	}
        	else if(command.equals("OPPONENT_SHOT")){
        		String text = (String) ois.readObject();
        		Shot shot = (Shot) ois.readObject(); 
        		if(text.equals("HIT")) {
        			playerField.hitMark(shot);
        		}
        		else if(text.equals("MISS"))
        			playerField.missMark(shot);
        		else if(text.equals("DESTROY")){
        			playerField.destroyMark(shot);
        		}
        		
        	}
        	else if(command.equals("END"))
        		return;
        	else
        		System.out.println("Strange: " + command);
        }
    }
    
    public void showFields(){
    	System.out.print("\t\tOPPONENT FIELD:");
    	System.out.print("\t\t\t\t\t");
    	System.out.println("YOUR FIELD:");
    	System.out.print("   | ");
		String [] abc={"A","B","C","D","E","F","G","H","I","J"};
		for(int i = 0; i < 10; i++){
			System.out.print(abc[i]+" | "); 
		}
		System.out.print("\t");
		System.out.print("   | ");
		for(int i = 0; i < 10; i++){
			System.out.print(abc[i]+" | "); 
		}
		System.out.println();
		System.out.print("--------------------------------------------");
		System.out.print("\t--------------------------------------------");
		System.out.println();
		
		int number=1;
		for(int i = 0; i < 10; i++){
			if(number<10){
				System.out.print(number+" ");
			} 
			else {
				System.out.print(number+"");
			}
			for(char cell : opponentField.getField()[i]){
				System.out.print(" | " + cell);
			}
			
			System.out.print("\t");
			if(number<10){
				System.out.print(number+" ");
			} 
			else {
				System.out.print(number+"");
			}
			for(char cell : playerField.getField()[i]){
				System.out.print(" | " + cell);
			}
			System.out.print(" |");
			System.out.println();
			System.out.print("--------------------------------------------");
			System.out.println("\t--------------------------------------------");
			number++;
		}
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client(InetAddress.getByName(args[0]));       
        System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
        client.start();                
    }
}
