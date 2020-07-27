package mapElement.monstros;

import mapElement.*;
=======
import mapElement.MapElement;
import Itens.*;
import Itens.potions.Potions;

public class Monster extends Personagem{


	public Monster( int x, int y) {
		super(x,y);
	}
	

	public int getAttack() {
		return this.attack;
	}

	public void setBody (int b) {
		this.body=b;		
	}
}	