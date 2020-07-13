import java.util.ArrayList;

public class Map {
	
	private int x;
	private int y;
	private ArrayList<Sala> salas;
	private Sala map[][];
	
	public Map(int px, int py, ArrayList<Sala> sala){
		x = px;
		y = py;
		salas = sala;
		map = new Sala[x][y];
	}
	
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Sala[][] getMap() {
		return map;
	}
	public void setMap(Sala map[][]) {
		this.map = map;
	}
	public ArrayList<Sala> getSalas() {
		return salas;
	}
	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}
	
	public void createMap(){
		for(int i  = 0; i < this.salas.size(); i++) {
			this.map[this.salas.get(i).getpX()][this.salas.get(i).getpY()] = this.salas.get(i);
		}
	}
	
	public void imprimeMap() {
		for (int i = 0; i < this.x; i++){
			for (int j = 0; j<this.y; j++){
				if(map[i][j] != null) {
					this.map[i][j].imprime();
				}
			}
			System.out.println("-");
		}
	}

}
