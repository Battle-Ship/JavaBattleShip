package application;

public class Field {
	
	char[][] field;
	
	public Field() {
		// TODO Auto-generated constructor stub
		field = new char[10][10];
		setField();
	}

	// Fills the field with '0'
	public void setField(){
		for(int row = 0; row < field.length; row++){
			for(int column = 0; column < field.length; column++){
				field[row][column] = ' ';
			}
		}
	}
	
	// Mark the cell in a field with a hit-mark
	public void hitMark(Shot shot){
		field[shot.getRow()][shot.getColumn()] = 'X';
	}
	
	// Mark the cell in a field with a miss-mark
	public void missMark(Shot shot){
		field[shot.getRow()][shot.getColumn()] = '*';
	}
	
	// Prints the field
	public void showField(){
		
		System.out.print("   | ");

		String [] abc={"A","B","C","D","E","F","G","H","I","J"};
		for(int i=0; i<field.length; i++){
		System.out.print(abc[i]+" | ");
		}
		System.out.println();
		System.out.println("--------------------------------------------");


		int number=1;
		for(char[] row : field){
			if(number<10){
			System.out.print(number+" ");
			} else {
				System.out.print(number+"");
	
			}
	
			for(char cell : row){
				System.out.print(" | " + cell);
			}
			System.out.print(" |");
		
	
			
			System.out.println();
			System.out.println("--------------------------------------------");
			number++;
		}
}
	
	public char[][] getField(){
		return field;
	}
}
