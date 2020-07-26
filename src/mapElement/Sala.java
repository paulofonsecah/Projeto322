package mapElement;
import java.util.ArrayList;
import java.util.Random;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import com.sun.xml.internal.ws.util.StringUtils;

import mapElement.herois.Heroi;
import mapElement.monstros.Monster;

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
	public MapElement room[][];
	
	
	public MapElement[][] getRoom() {
		return room;
	}


	public void setRoom(MapElement[][] room) {
		this.room = room;
	}


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
		if(monstro.getX() <= this.x-1) {
			if(monstro.getY() <= this.y-1) {
				this.monstros.add(monstro);
			}else {
				if(this.y-1 != 0) {
					Random random = new Random();
					int indice = random.nextInt(this.y-1);
					monstro.setY(indice);
					this.setMonstros(monstro);
				}else {
					monstro.setY(0);
					this.setMonstros(monstro);
				}
			}
		}else {
			if(this.x-1 != 0) {
				Random random = new Random();
				int indice = random.nextInt(this.x-1);
				monstro.setX(indice);
				this.setMonstros(monstro);
			}else {
				monstro.setX(0);
				this.setMonstros(monstro);
			}
		}
	}
	
	public ArrayList<Trap> getArmadilhas() {
		return armadilhas;
	}
	
	public void setArmadilhas(Trap armadilha) {
		if(armadilha.getX() <= this.x-1) {
			if(armadilha.getY() <= this.y-1) {
				this.armadilhas.add(armadilha);
			}else {
				if(this.y-1 != 0) {
					Random random = new Random();
					int indice = random.nextInt(this.y-1);
					armadilha.setY(indice);
					this.setArmadilhas(armadilha);
				}else {
					armadilha.setY(0);
					this.setArmadilhas(armadilha);
				}
			}
		}else {
			if(this.x-1 != 0) {
				Random random = new Random();
				int indice = random.nextInt(this.x-1);
				armadilha.setX(indice);
				this.setArmadilhas(armadilha);
			}else {
				armadilha.setX(0);
				this.setArmadilhas(armadilha);
			}
		}
	}
		
	public ArrayList<Treasures> getTesouros() {
		return tesouros;
	}
	
	public void setTesouros(Treasures tesouro) {		
		if(tesouro.getX() <= this.x-1) {
			if(tesouro.getY() <= this.y-1) {
				this.tesouros.add(tesouro);
			}else {
				if(this.y-1 != 0) {
					Random random = new Random();
					int indice = random.nextInt(this.y-1);
					tesouro.setY(indice);
					this.setTesouros(tesouro);
				}else {
					tesouro.setY(0);
					this.setTesouros(tesouro);
				}
			}
		}else {
			if(this.x-1 != 0) {
				Random random = new Random();
				int indice = random.nextInt(this.x-1);
				tesouro.setX(indice);
				this.setTesouros(tesouro);
			}else {
				tesouro.setX(0);
				this.setTesouros(tesouro);
			}
		}
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
				if(!(this.room[i][j] instanceof Nulo)) {
					this.room[i][j] = new Empty (i,j);
				}
			}
		}
		for(int i  = 0; i < this.portas.size(); i++) {
			this.room[this.portas.get(i).getX()][this.portas.get(i).getY()] = this.portas.get(i);
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
	}
	
	public void addnulo(int x, int y) {
		this.room[x][y] = new Nulo(x,y);
	}
	public void addHero(Heroi hero) {
		this.room[hero.getX()][hero.getY()] =hero;
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
				}else if(this.room[i][j] instanceof Nulo) {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}
	public void imprime(int k, boolean s,Sala sala) {
		for (int j = 0; j < this.y; j++){
			if(k<this.x) {
				if(this.room[k][j] instanceof Empty) {
					if (s) {
						System.out.print("V͟");
					}else {
						System.out.print("V");
					}
				}else if(this.room[k][j] instanceof Monster) {
					if (s) {
						System.out.print("M͟");
					}else {
						System.out.print("M");
					}
				}else if(this.room[k][j] instanceof Trap) {
					if (s) {
						System.out.print("A͟");
					}else {
						System.out.print("A");
					}
				}else if(this.room[k][j] instanceof Treasures) {
					if (s) {
						System.out.print("T͟");
					}else {
						System.out.print("T");
					}
				}else if(this.room[k][j] instanceof Door) {
					if (s && sala!=null && !(sala.getRoom()[0][j] instanceof Door)) {
						System.out.print("*͟");
					}else {
						System.out.print("*");
					}
				}else if(this.room[k][j] instanceof Nulo) {
					System.out.print("X");
				}else if(this.room[k][j] instanceof Heroi) {
					if (s) {
						System.out.print("H͟");
					}else {
						System.out.print("H");
					}
				}
			}else {
				System.out.print("X");
				
			}
			
		}
	}
	
}
