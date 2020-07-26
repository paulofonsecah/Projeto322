package Itens.magias;

import mapElement.Personagem;

public class MagicMissile implements Magia {
		
	@Override
	public void ehUsada(Personagem personagem) {
		int dano=6;
		personagem.decreaseBodyPoints(dano);
	}
	
}
