package game;
import java.util.ArrayList;

public class Heroi extends MapElement {
	
	public char name;
	private int attack;
	private int deffense;
	private int mind;
	private int body;
	private int hands; //0-3
	

	public int getxSala() {
		return xSala;
	}

	public void setxSala(int xSala) {
		this.xSala = xSala;
	}

	public int getySala() {
		return ySala;
	}

	public void setySala(int ySala) {
		this.ySala = ySala;
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


	private int xSala;
	private int ySala;
	private int x;
	private int y;
	
	public ArrayList<Armas> armas;
	public ArrayList<Armor> armaduras; //MAX 2 COMO SETAR?
	public ArrayList<Potions> pocoes;
	
	public int Sala;
	
	public Heroi(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, char n, int at, int d, int m, int b,int xs,int ys,int xp,int yp) {
		this.name=n;
		this.attack=at;
		this.deffense=d;
		this.mind=m;
		this.body=b;
		this.xSala = xs;
		this.ySala = ys;
		this.x = xp;
		this.x= yp;
		
		armas=w;
		armaduras=a;
		pocoes=p;
	}
	
	public ArrayList<Armas> getArmas()
		return armas;
		
	public void setArmas(ArrayList<Armas> armas) 
		this.armas = armas;
	
	public ArrayList<Armor> getArmor()
		return armaduras;
	
	public void setArmor(ArrayList<Armor> armaduras)
		this.armaduras=armaduras;
	
	public ArrayList<Potions> getPotions()
	return pocoes;

	public int getHands()
		return this.hands;
	
	public void increaseBodyPoints (int cura) {
		this.body=this.body+cura;		
	}
	
	public void increaseAttackPoints (int fortalece) {
		this.body=this.body+fortalece;		
	}
	
	public void increaseDeffensePoints (int protege) {
		this.body=this.body+protege;		
	}
	
	public void increaseMindPoints (int protege) {
		this.body=this.body+protege;		
	}
	
	//Bebe Po��es
	public void setPotions(ArrayList<Potions> pocoes)
		this.pocoes=pocoes;	
	
	private void drinkPotion (Potions pocao) {
		
		
	}
	

	
}
