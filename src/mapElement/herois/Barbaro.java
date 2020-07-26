package mapElement.herois;

import itens.Armor;
import itens.armas.*;
import itens.potions.*;

import java.util.ArrayList;


public class Barbaro extends Heroi{
	
	EspadaLonga espadaLonga =new EspadaLonga();
	
	public Barbaro(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, int px, int py) {
		super(w,a,p,px,py);
		
		this.name="B";
		this.attack=3;
		this.deffense=2;
		this.mind=2;
		this.body=8;
		
		this.fullHands=2;
		
		armas.add(espadaLonga);
	}
	

}
