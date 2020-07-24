
import java.util.ArrayList;
import java.util.Random;


public class Map {
	
	private int x;
	private int y;
	private ArrayList<Sala> salas;
	public Sala map[][];
	
	public Map(int px, int py){
		x = px;
		y = py;
		salas = new ArrayList<Sala>();
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
	
	
	public void createRooms(Sala room){
		
		this.salas.add(room);
		
	}
	
	public void randomMap(ArrayList<Monster> m, ArrayList<Trap> a, ArrayList<Treasures> t) {
		
		Random random = new Random();
		
		for(int i = 0; i < m.size();i++) {
			int indice = random.nextInt(this.salas.size()-1);
			this.salas.get(indice).setMonstros(m.get(i));
		}
		
		for(int i = 0; i < a.size();i++) {
			int indice = random.nextInt(this.salas.size()-1);
			this.salas.get(indice).setArmadilhas(a.get(i));
		}
		
		for(int i = 0; i < t.size();i++) {
			int indice = random.nextInt(this.salas.size()-1);
			this.salas.get(indice).setTesouros(t.get(i));
		}
		
		for(int i = 0; i < m.size();i++) {
			int indice = random.nextInt(this.salas.size()-1);
			this.salas.get(indice).setMonstros(m.get(i));
		}
		
		
	}
	
	public void createMap(){
		for(int i  = 0; i < this.salas.size(); i++) {
			this.salas.get(i).createRoom();
			this.map[this.salas.get(i).getpX()][this.salas.get(i).getpY()] = this.salas.get(i);
		}
	}
	
	
	public void imprimeMap() {
		for (int i = 0; i < this.x; i++){
			for (int k = 0; k<this.map[i][0].getX(); k++){
				for (int j = 0; j<this.y; j++){
					if(map[i][j] != null) {
						this.map[i][j].imprime(k);
						System.out.print("|");
					}
				}
				System.out.println("");
			}
		}
	}

}
