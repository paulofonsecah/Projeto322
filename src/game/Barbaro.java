package game;
import java.util.ArrayList;

public class Barbaro extends Heroi{

	public Barbaro(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, char n) {
		this.name=n;
		this.attack=3;
		this.deffense=2;
		this.mind=2;
		this.body=8;
		
		armas=w;
		armaduras=a;
		pocoes=p;
	}
	

}
