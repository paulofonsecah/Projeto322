package itens.potions;

import mapElement.herois.Heroi;

public class StrenghtenPot implements Potions {

	public void ehUsada (Heroi hero) {
		int fortalece=2;
		hero.increaseAttackDices(fortalece); 
	}

}