package game;
import java.util.ArrayList;

public class Anao extends Heroi {
	
	public Anao(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, char n) {
		this.name=n;
		this.attack=2;
		this.deffense=2;
		this.mind=3;
		this.body=7;
		
		armas=w;
		armaduras=a;
		pocoes=p;
	}

}
