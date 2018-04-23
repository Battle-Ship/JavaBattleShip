
public interface Location {
	
	public boolean hasShips();
	public void setField();
	public void setShips();
	public void hitMark(int[] shot);
	public void missMark(int[] shot);
	public void showField();
	public char[][] getField();
}
