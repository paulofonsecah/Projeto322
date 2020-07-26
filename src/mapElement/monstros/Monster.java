package mapElement.monstros;

import mapElement.MapElement;
import Itens.*;

import java.util.ArrayList;


public class Monster extends MapElement{

	public ArrayList<Armas> armas;
	protected int attack;
	protected int body; //HP

	public Monster(ArrayList<Armas> w, int x, int y) {
		super(x,y);
		armas=w;
	}

	public ArrayList<Armas> getArmas(){
		return armas;
	}	
		
	public void setArmas(ArrayList<Armas> armas) { 
		this.armas = armas;
	}
	
	public int getHP() {
		return this.body;
	}
	

}
