package itens.potions;

import mapElement.herois.Heroi;

public class EnlightenPot implements Potions {

	@Override
	public void ehUsada(Heroi hero) {
		int ensina=2;
		hero.increaseMindPoints(ensina); 

	}

}
