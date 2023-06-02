package orchard.model;

public class Piece {
	private int coordinateX;
	private int coordinateY;
	
	public Piece(int coordinateX, int coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
	public int getCoordinateX() {
		return this.coordinateX;
	}
	
	public int getCoordinateY() {
		return this.coordinateY;
	}
}
