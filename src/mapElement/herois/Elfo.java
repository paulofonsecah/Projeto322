package mapElement.herois;



import java.util.ArrayList;

import itens.Armor;
import itens.armas.Armas;
import itens.potions.Potions;
import itens.magias.*;

public class Elfo extends Heroi{
	
	public ArrayList<Magia> magias;
	
	public Elfo(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, ArrayList<Magia> m, int px, int py) {
		super(w,a,p,px,py);
		
		this.name="E";
		this.attack=2;
		this.deffense=2;
		this.mind=4;
		this.body=6;
		
		magias= m;
		armas=w;
		armaduras=a;
		pocoes=p;
	}


	public ArrayList<Magia> getMagias(){
	return magias;
	}

	public void setMagias(ArrayList<Magia> magia) {
		this.magias=magia;	
	}
	
	public void castSpell (Magia magia) {
		boolean status=false;	
		for( Magia o : this.magias ) {
			if(o.getClass()==magia.getClass()) {
				status=true;
			}
		}
		if(status) {
			magia.ehUsada(this);
		}
	}
}