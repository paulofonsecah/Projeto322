package mapElement.monstros;

import java.util.ArrayList;

import itens.armas.Armas;

public class Esqueleto extends Monster{

	public Esqueleto(ArrayList<Armas> w, int x, int y) {
		super(w,x,y);
		
		this.body=2;
		this.attack=1;		
	}
}
