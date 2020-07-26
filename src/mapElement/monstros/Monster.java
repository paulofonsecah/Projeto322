package mapElement.monstros;

import mapElement.*;
import itens.armas.Armas;

import java.util.ArrayList;


public class Monster extends Personagem{


	public Monster(ArrayList<Armas> w, int x, int y) {
		super(x,y);
		armas=w;
	}
	
}
