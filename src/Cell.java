
public class Cell {

	private int row, column;
	private boolean alive;
	
	public Cell(int column, int row) {
		//System.out.println("Cell: column: " + column + " row: " + row);
		this.row = row;
		this.column = column;
		alive = true;
	}
	
	int getRow() { return row; }
	int getColumn() { return column; }
	
	boolean checkHit(int column, int row) {
		if (this.column == column && this.row == row) {
			return true;
		}
		return false;
	}
	
	public void destroy() {
		alive = false;
	}
	boolean isAlive() {
	        return alive;
	}
	
	public String toString() {
		return "Column: " + column + " Row: " + row;
	}
}