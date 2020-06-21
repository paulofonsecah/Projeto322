import java.util.ArrayList;

public class Salas {
	
	private ArrayList<Monster> monstros;
	private ArrayList<Trap> armadilhas;
	private ArrayList<Treasures> tesouros;
	
	public Salas (ArrayList<Monster> m, ArrayList<Trap> a, ArrayList<Treasures> t) {
		monstros = m;
		armadilhas = a;
		tesouros = t;
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
	
}
