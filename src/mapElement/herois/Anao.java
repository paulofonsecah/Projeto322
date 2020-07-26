package mapElement.herois;


import java.util.ArrayList;

import itens.Armor;
import itens.armas.*;
import itens.potions.Potions;


public class Anao extends Heroi {
	
	EspadaCurta espadaCurta =new EspadaCurta();
	public ArrayList<Armas> inicio;
	
	public Anao(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, int px, int py) {
		
		super(w, a, p , px, py);
		
		this.name="D";
		this.attack=2;
		this.deffense=2;
		this.mind=3;
		this.body=7;
		
		this.inicio.add(espadaCurta);
		
		this.setArmas(inicio);
		
		armaduras=a;
		pocoes=p;
	}

}
