package mapElement.monstros;

import java.util.ArrayList;

import itens.armas.Armas;

public class Goblin extends Monster{

	public Goblin(ArrayList<Armas> w, int x, int y) {
		super(w,x,y);
		
		this.body=3;
		this.attack=1;		
	}
}
