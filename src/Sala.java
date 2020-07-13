import java.util.ArrayList;

public class Sala {
	
	private ArrayList<Monster> monstros;
	private ArrayList<Trap> armadilhas;
	private ArrayList<Treasures> tesouros;
	private ArrayList<Door> portas;
	private int x;
	private int y;
	private int pX;
	private int pY;
	private MapElement room[][];
	
	
	public Sala (ArrayList<Monster> m, ArrayList<Trap> a, ArrayList<Treasures> t, ArrayList<Door> p, int px, int py, int az, int b) {
		monstros = m;
		armadilhas = a;
		tesouros = t;
		setPortas(p);
		x = px;
		y = py;
		pX = az;
		pY = b;
		room = new MapElement[px][py];
	}
	
	
	public ArrayList<Monster> getMonstros() {
		return monstros;
	}
	public void setMonstros(ArrayList<Monster> monstros) {
		this.monstros = monstros;
	}
	public ArrayList<Trap> getArmadilhas() {
		return armadilhas;
	}
	public void setArmadilhas(ArrayList<Trap> armadilhas) {
		this.armadilhas = armadilhas;
	}
	public ArrayList<Treasures> getTesouros() {
		return tesouros;
	}
	public void setTesouros(ArrayList<Treasures> tesouros) {
		this.tesouros = tesouros;
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
	
	public int getpX() {
		return pX;
	}


	public void setpX(int pX) {
		this.pX = pX;
	}


	public int getpY() {
		return pY;
	}


	public void setpY(int pY) {
		this.pY = pY;
	}


	public ArrayList<Door> getPortas() {
		return portas;
	}


	public void setPortas(ArrayList<Door> portas) {
		this.portas = portas;
	}
	
	public void createRoom(){
		for (int i = 0; i < this.x; i++){
			for (int j = 0; j<this.y; j++){
				this.room[i][j] = new Empty (i,j);
			}
		}
		for(int i  = 0; i < this.monstros.size(); i++) {
			this.room[this.monstros.get(i).getX()][this.monstros.get(i).getY()] = this.monstros.get(i);
		}
		for(int i  = 0; i < this.armadilhas.size(); i++) {
			this.room[this.armadilhas.get(i).getX()][this.armadilhas.get(i).getY()] = this.armadilhas.get(i);
		}
		for(int i  = 0; i < this.tesouros.size(); i++) {
			this.room[this.tesouros.get(i).getX()][this.tesouros.get(i).getY()] = this.tesouros.get(i);
		}
		for(int i  = 0; i < this.portas.size(); i++) {
			this.room[this.portas.get(i).getX()][this.portas.get(i).getY()] = this.portas.get(i);
		}
	}
	
	public void imprime() {
		for (int i = 0; i < this.x; i++){
			for (int j = 0; j<this.y; j++){
				System.out.print(this.room[i][j].getClass() + " ");
			}
			System.out.println();
		}
	}
	
}
