package game;
import java.util.ArrayList;

public class Feiticeiro extends Heroi{
	
	public ArrayList<Magias> magia;
	
	public Elfo(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p, ArrayList<Magias> m, char n) {
		this.name=n;
		this.attack=1;
		this.deffense=2;
		this.mind=6;
		this.body=4;
		
		magia= m
		armas=w;
		armaduras=a;
		pocoes=p;
	}

}

public ArrayList<Magias> getMagias()
return magia;

public void setMagias(ArrayList<Magias> magia)
	this.magia=magia;	