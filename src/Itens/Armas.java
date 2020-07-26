
package Itens;

public class Armas implements Item{
	
	protected int alcance;
	protected int bonusDados;
	protected boolean ehDestruida;
	
	public Armas(int a, int b, boolean d) {
		alcance = a;
		bonusDados = b;
		ehDestruida = d;
	}	
	
	public boolean isEhdestruida() {
		return ehDestruida;
	}
	public void setEhdestruida(boolean ehdestruida) {
		this.ehDestruida = ehDestruida;
	}
	public int getBonus() {
		return bonusDados;
	}
	public void setBonus(int bonusDados) {
		this.bonusDados = bonusDados;
	}
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}	
	
}