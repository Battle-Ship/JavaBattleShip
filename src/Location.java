

public interface Location {
	
	public boolean hasShips();

	public void setField();

	public void setShips();

	public void hitMark(Shot shot);

	public void missMark(Shot shot);

	public void showField();

	public char[][] getField();
}
