package mapElement.herois;
import java.util.ArrayList;

import Itens.*;
import Itens.potions.*;
public class Anao extends Heroi {
	
	public Anao(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, int px, int py,int sx,int sy) {
		
		super(w, a, p , px, py,sx,sy);
		
		this.name="D";
		this.attack=2;
		this.deffense=2;
		this.mind=3;
		this.body=7;
		
		armas=w;
		armaduras=a;
		pocoes=p;
	}

}
