package mapElement.herois;



import java.util.ArrayList;

import Itens.Armas;
import Itens.Armor;
import Itens.potions.Potions;


public class Elfo extends Heroi{
	
	public ArrayList<Magias> magia;
	
	public Elfo(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, int px, int py) {
		super(w,a,p,px,py);
		
		this.name="E";
		this.attack=2;
		this.deffense=2;
		this.mind=4;
		this.body=6;
		
		magia= m;
		armas=w;
		armaduras=a;
		pocoes=p;
	}

}

public ArrayList<Magias> getMagias()
return magia;

public void setMagias(ArrayList<Magias> magia)
	this.magia=magia;	