
public class Armas extends MapElement{
	
	private int alcance;
	private int bonus;
	private boolean ehdestruida;
	
	//Valeska passou por aqui
	public Armas(int a, int b, boolean d, int x, int y) {
		super(x,y);
		alcance = a;
		bonus = b;
		ehdestruida = d;
	}	
	
	public boolean isEhdestruida() {
		return ehdestruida;
	}
	public void setEhdestruida(boolean ehdestruida) {
		this.ehdestruida = ehdestruida;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}	
	
}