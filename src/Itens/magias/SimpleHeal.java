package Itens.magias;

import mapElement.Personagem;

public class SimpleHeal implements Magia {
	
	private int dado;
	public SimpleHeal(int dadoSeis) {
		this.dado=dadoSeis;
	}
	
	@Override
	public void ehUsada(Personagem heroi) {
		heroi.increaseBodyPoints(this.dado);
	}

}