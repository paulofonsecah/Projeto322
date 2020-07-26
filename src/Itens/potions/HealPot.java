package itens.potions;

import mapElement.herois.Heroi;

public class HealPot implements Potions{
	
	public void ehUsada (Heroi hero) {
		int cura=2;
		hero.increaseBodyPoints(cura); 
	}
}
