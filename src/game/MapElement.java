package game;

public class MapElement {
	
	private int x;
	private int y;
	
	public MapElement(int px, int py) {
		setX(px);
		setY(py);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}
