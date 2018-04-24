
public class Field {
	
	char[][] field;
	
	public Field() {
		// TODO Auto-generated constructor stub
		field = new char[10][10];
		setField();
	}

	// Fills the field with '0'
	public void setField(){
		for(int row = 0; row < 10; row++){
			for(int column = 0; column < 10; column++){
				field[row][column] = '0';
			}
		}
	}
	
	// Mark the cell in a field with a hit-mark
	public void hitMark(int[] shot){
		int shotX = shot[0];
		int shotY = shot[1];
		field[shotX][shotY] = 'X';
	}
	
	// Mark the cell in a field with a miss-mark
	public void missMark(int[] shot){
		int shotX = shot[0];
		int shotY = shot[1];
		field[shotX][shotY] = '*';
	}
	
	// Prints the field
	public void showField(){
		System.out.print(" ");
		for(int i=1; i<=10; i++){
			System.out.print(" | ");
			System.out.print(i);
		}
		System.out.println(" | ");
		int number=0;
		for(char[] row : field){
			String [] abc={"A","B","C","D","E","F","G","H","J","E"};
			System.out.print(abc[number]);

			for(char cell : row){
				System.out.print(" | " + cell);
			}
			System.out.print(" |");
			System.out.println();
			number++;
		}
}
	
	public char[][] getField(){
		return field;
	}
}
