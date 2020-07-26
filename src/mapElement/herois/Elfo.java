package mapElement.herois;
import java.util.ArrayList;

import Itens.Armas;
import Itens.Armor;
import Itens.potions.Potions;

import magias.*;

public class Elfo extends Heroi{
	
	public ArrayList<Magia> magia;
	
	public Elfo(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p,ArrayList<Magia> m, int px, int py,int sx,int sy) {
		super(w,a,p,px,py,sx,sy);
		
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

	public ArrayList<Magia> getMagias() {
	
		return magia;		
	}
	
	public void setMagias(ArrayList<Magia> magia) {
		this.magia=magia;
	}
		
}