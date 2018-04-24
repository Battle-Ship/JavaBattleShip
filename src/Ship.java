import java.util.ArrayList;

public class Ship {

	private ArrayList<Cell> cells = new ArrayList<Cell>();
	int row, column, length, position;
	
	Ship (int row, int column, int length, int position) {
		for (int i = 0; i< length; i++)
            cells.add(
                new Cell(row + i * ((position == 1)? 0 : 1),
                    column + i * ((position == 1)?1:0)));
        this.row = row;;
        this.column = column;
        this.length = length;
        this.position = position;
    }

    // is ship outside the boundary of the field?
    boolean isOutOfField(int bottom, int top) {
        for (Cell cell : cells)
            if (cell.getRow() < bottom || cell.getRow() > top ||
                cell.getColumn() < bottom || cell.getColumn() > top)
                return true;
        return false;
    }

    boolean isOverlayOrTouch(Ship checkShip) { // is ship overlay or touch other ships
        for (Cell cell : cells)
            if (checkShip.isOverlayOrTouchCell(cell))
                return true;
        return false;
    }

    boolean isOverlayOrTouchCell(Cell ctrlCell) {
        for (Cell cell : cells)
            for (int dx = -1; dx < 2; dx++)
                for (int dy = -1; dy < 2; dy++)
                    if (ctrlCell.getRow() == cell.getRow() + dx &&
                        ctrlCell.getColumn() == cell.getColumn() + dy)
                        return true;
        return false;
    }

    boolean checkHit(int x, int y) {
        for (Cell cell : cells)
            if (cell.checkHit(x, y))
                return true;
        return false;
    }

    boolean isAlive() {
        for (Cell cell : cells)
            if (cell.isAlive())
                return true;
        return false;
    }
    
    public String toString(){
    	return "row: " + Integer.toString(row) + " column: " + Integer.toString(column) + " len: " + Integer.toString(length) + " pos: " + Integer.toString(position);
    }

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getLength() {
		return length;
	}

	public int getPosition() {
		return position;
	}
}
