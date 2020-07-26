package mapElement.herois;


import java.util.ArrayList;

import Itens.Armas;
import Itens.Armor;
import itens.potions.Potions;

public class Feiticeiro extends Heroi{
	
	public ArrayList<Magias> magia;
	
	public Feiticeiro(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, ArrayList<Magias> m, int px, int py) {
		
		super(w, a, p , px, py);
		
		this.name="W";
		this.attack=1;
		this.deffense=2;
		this.mind=6;
		this.body=4;
		
		magia= m;
		armas=w;
		armaduras=a;
		pocoes=p;
	}

	public ArrayList<Magias> getMagias(){
	return magia;
	}
	
	public void setMagias(ArrayList<Magias> magia) {
		this.magia=magia;	

	}

}