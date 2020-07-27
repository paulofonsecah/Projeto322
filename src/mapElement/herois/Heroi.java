package mapElement.herois;


import java.util.ArrayList;

import Itens.*;
import Itens.potions.*;
import mapElement.MapElement;

public class Heroi extends MapElement {
	
	public String name;
	protected int attack;
	protected int deffense;
	protected int mind;
	protected int body;
	protected int fullHands; //0-3
	protected int salaY; 
	protected int salaX;
	public int Sala;
	
	public int getSalaY() {
		return salaY;
	}

	public void setSalaY(int salaY) {
		this.salaY = salaY;
	}

	public int getSalaX() {
		return salaX;
	}

	public void setSalaX(int salaX) {
		this.salaX = salaX;
	}

	
	protected ArrayList<Armas> armas;
	protected ArrayList<Armor> armaduras; //MAX 2 COMO SETAR?
	protected ArrayList<Potions> pocoes;
	
	public ArrayList<Item> bolsa;
	
	
	public Heroi(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p,int sx,int sy,int px, int py) {
		super(px,py);	
		this.name="H";
		salaX = sx;
		salaY = sy;
		armas=w;
		armaduras=a;
		pocoes=p;
		attack=3;
		mind=3;

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
	
	public ArrayList<Armor> getArmor(){
		return armaduras;
	}
	
	public void setArmor(ArrayList<Armor> armaduras) {
		this.armaduras=armaduras;
	}
	
	public ArrayList<Potions> getPotions(){
		return pocoes;
	}
	
	public int getFullHands() {
		return this.fullHands;
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

	public void increaseBodyPoints (int b) {
		this.body+=b;
	}
	public void increaseAttackDices (int b) {
		this.attack+=b;
	}
	public void increaseMindPoints (int b) {
		this.mind+=b;
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

	public void setPotions(ArrayList<Potions> pocoes) {
		this.pocoes=pocoes;	
	}
	
	public void drinkPotion (Potions pocao) {
		boolean status=false;	
		for( Potions o : this.pocoes ) {
				if(o.getClass()==pocao.getClass()) {
				status=true;
				}
		}
		if(status) {
			pocao.ehUsada(this);
			this.pocoes.remove(pocao);
		}
	}
	
	
}
