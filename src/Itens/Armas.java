
package Itens;

public class Armas implements Item{
	
	protected int alcance;
	protected int bonusDados;
	protected boolean ehDestruida;
	protected String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Armas(int a, int b, boolean d,String nomeX) {
		alcance = a;
		bonusDados = b;
		ehDestruida = d;
		nome =nomeX;
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