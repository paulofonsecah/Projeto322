import java.util.ArrayList;

public class Sala {
	
	//Elementos da sala
	private ArrayList<Monster> monstros;
	private ArrayList<Trap> armadilhas;
	private ArrayList<Treasures> tesouros;
	private ArrayList<Door> portas;
	//Tamanho da sala
	private int x;
	private int y;
	//Posicao no array de salas
	private int pX;
	private int pY;
	//Sala propriamente dita
	private MapElement room[][];
	
	
	public Sala (ArrayList<Door> p, int tx, int ty, int px, int py) {
		setPortas(p);
		x = tx;
		y = ty;
		pX = px;
		pY = py;
		room = new MapElement[tx][ty];
		monstros = new ArrayList<Monster>();
		armadilhas = new ArrayList<Trap>();
		tesouros = new ArrayList<Treasures>();
	}
	
	
	public ArrayList<Monster> getMonstros() {
		return monstros;
	}
	public void setMonstros(Monster monstro) {
		this.monstros.add(monstro);
	}
	public ArrayList<Trap> getArmadilhas() {
		return armadilhas;
	}
	public void setArmadilhas(Trap armadilha) {
		this.armadilhas.add(armadilha);
	}
	public ArrayList<Treasures> getTesouros() {
		return tesouros;
	}
	public void setTesouros(Treasures tesouro) {
		this.tesouros.add(tesouro);
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
			if(this.room[this.monstros.get(i).getX()][this.monstros.get(i).getY()] instanceof Empty){
				this.room[this.monstros.get(i).getX()][this.monstros.get(i).getY()] = this.monstros.get(i);
			}else {
				System.out.println("Já existe algo nesta posição, este monstro não foi adicionado!");
			}
		}
		for(int i  = 0; i < this.armadilhas.size(); i++) {
			if(this.room[this.armadilhas.get(i).getX()][this.armadilhas.get(i).getY()] instanceof Empty){
				this.room[this.armadilhas.get(i).getX()][this.armadilhas.get(i).getY()] = this.armadilhas.get(i);
			}else {
				System.out.println("Já existe algo nesta posição, esta armadilha não foi adicionada!");
			}
		}
		for(int i  = 0; i < this.tesouros.size(); i++) {
			if(this.room[this.tesouros.get(i).getX()][this.tesouros.get(i).getY()] instanceof Empty){
				this.room[this.tesouros.get(i).getX()][this.tesouros.get(i).getY()] = this.tesouros.get(i);
			}else {
				System.out.println("Já existe algo nesta posição, este tesouro não foi adicionado!");
			}
			
		}
		for(int i  = 0; i < this.portas.size(); i++) {
			this.room[this.portas.get(i).getX()][this.portas.get(i).getY()] = this.portas.get(i);
		}
	}
	
	public void imprime() {
		for (int i = 0; i < this.x; i++){
			for (int j = 0; j<this.y; j++){
				if(this.room[i][j] instanceof Empty) {
					System.out.print("*");
				}else if(this.room[i][j] instanceof Monster) {
					System.out.print("M");
				}else if(this.room[i][j] instanceof Trap) {
					System.out.print("A");
				}else if(this.room[i][j] instanceof Treasures) {
					System.out.print("T");
				}else if(this.room[i][j] instanceof Door) {
					System.out.print("P");
				}
			}
			System.out.println();
		}
	}
	
}
