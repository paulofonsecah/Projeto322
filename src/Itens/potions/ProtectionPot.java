package itens.potions;

import mapElement.herois.Heroi;

public class ProtectionPot implements Potions {

	public void ehUsada (Heroi hero) {
		int protege=2;
		hero.increaseDeffenseDices(protege); 
	}
}
