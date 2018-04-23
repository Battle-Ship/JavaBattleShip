
public class Field {
	
	char[][] field;
	
	public Field() {
		// TODO Auto-generated constructor stub
		field = new char[5][5];
		setField();
	}

	// Fills the field with '0'
	public void setField(){
		for(int row = 0; row < 5; row++){
			for(int column = 0; column < 5; column++){
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
}
