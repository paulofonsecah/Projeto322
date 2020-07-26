package Itens;

public class Armas implements Item{
	
	protected int alcance;
	protected int bonus;
	protected boolean ehdestruida;
	
	//Valeska passou por aqui
	public Armas(int a, int b, boolean d) {
		alcance = a;
		bonusDados = b;
		ehDestruida = d;
	}	
	
	public boolean isEhdestruida() {
		return ehDestruida;
	}
	public void setEhdestruida(boolean ehdestruida) {
		this.ehDestruida = ehdestruida;
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