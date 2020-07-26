package mapElement.monstros;

import mapElement.MapElement;
import Itens.*;

import java.util.ArrayList;


public class Monster extends MapElement{

	public ArrayList<Armas> armas;
	protected int attack;

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public void tomarDano(int dano) {
		this.body -= dano;
	}

	protected int body; //HP

	public Monster(ArrayList<Armas> w, int x, int y,int b) {
		super(x,y);
		armas=w;
		body=b;
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
