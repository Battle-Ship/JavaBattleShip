
public class Cell {

	private int row, column;
	private boolean alive;
	
	public Cell(int row, int column) {
		 this.row = row;
		 this.column = column;
		 alive = true;
	}
	
	int getRow() { return row; }
	int getColumn() { return column; }
	
	boolean checkHit(int x, int y) {
		if (this.row == x && this.column == y) {
			return true;
		}
		return false;
	}
	 
	boolean isAlive() {
	        return alive;
	}
}