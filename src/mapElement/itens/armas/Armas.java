package itens.armas;

import itens.Item;

public class Armas implements Item{
	
	protected int alcance;
	protected int bonusDados;
	protected int dano;
	public int ocupaMaos;
	public String nome; 
	protected boolean ehDestruida;
	
	
	//Valeska passou por aqui
	public Armas() {
		//alcance = a;
		//bonusDados = b;
		//ehDestruida = d;
	}	
	
	public boolean isEhdestruida() {
		return ehDestruida;
	}
	public void setEhdestruida(boolean ehdestruida) {
		this.ehDestruida = ehdestruida;
	}
	public int getBonus() {
		return bonusDados;
	}
	public void setBonus(int bonus) {
		this.bonusDados = bonus;
	}
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}	
	
}