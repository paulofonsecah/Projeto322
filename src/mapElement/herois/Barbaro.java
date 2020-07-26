package mapElement.herois;
import Itens.*;
import Itens.potions.*;

import java.util.ArrayList;


public class Barbaro extends Heroi{

	public Barbaro(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, int px, int py) {
		super(w,a,p,px,py);
		
		this.name="B";
		this.attack=3;
		this.deffense=2;
		this.mind=2;
		this.body=8;
		
		armas=w;
		armaduras=a;
		pocoes=p;
	}
	

}
