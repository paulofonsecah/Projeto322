package mapElement.monstros;

import mapElement.MapElement;
import Itens.*;
import Itens.potions.Potions;

import java.util.ArrayList;


public class Monster extends MapElement{

	public String name;
	protected int attack;
	protected int deffense;
	protected int mind;
	protected int body;
	
	protected ArrayList<Armas> armas;
	
	public Monster(ArrayList<Armas> w, String name, int px, int py, int at, int def, int mind, int body) { 
		super(px,py);	
		this.name="name";
		this.armas=w;
		this.attack=at;
		this.deffense=def;
		this.mind=mind;
		this.body=body;
	}
	
	public void setNome (String nome) {
		this.name=nome;
	} 
	
	public ArrayList<Armas> getArmas(){
		return armas;
	}	
		
	public void setArmas(ArrayList<Armas> armas) { 
		this.armas = armas;
	}
	
	
	public int getBody() {
		return this.body;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getDeffense() {
		return this.deffense;
	}

	public int getMind() {
		return this.mind;
	}
	public void setBody (int b) {
		this.body=b;		
	}
	
	public void setAttack (int at) {
		this.attack=at;		
	}
	
	public void setDeffense (int def) {
		this.deffense=def;		
	}
	
	public void setMind (int mind) {
		this.mind=mind;		
	}


	

}
