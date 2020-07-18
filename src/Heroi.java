import java.util.ArrayList;

public class Heroi {
	
	public char name;
	private int attack;
	private int deffense;
	private int mind;
	private int body;
	
	public ArrayList<Armas> armas;
	public ArrayList<Armor> armaduras;
	public ArrayList<Potions> pocoes;
	
	public int Sala;
	
	public Heroi(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, char n, int at, int d, int m, int b) {
		this.name=n;
		this.attack=at;
		this.deffense=d;
		this.mind=m;
		this.body=b;
		
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

	public void setPotions(ArrayList<Potions> pocoes)
		this.pocoes=pocoes;	
	
}
