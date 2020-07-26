package mapElement.monstros;

import mapElement.MapElement;

public class Monster extends MapElement{

	protected int ataque;

	public Monster(int x, int y) {
		super(x,y);
		this.ataque=1;
	}


}
