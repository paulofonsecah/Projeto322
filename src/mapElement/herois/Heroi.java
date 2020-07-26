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

	protected int salaX;
	
	protected ArrayList<Armas> armas;
	protected ArrayList<Armor> armaduras; //MAX 2 COMO SETAR?
	protected ArrayList<Potions> pocoes;
	
	public ArrayList<Item> bolsa;
	
	public int Sala;
	
	public Heroi(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p,int sx,int sy,int px, int py) { //COORDENADAS?? ArrayList<Armas> w, ArrayList<Armor> a,
		super(px,py);	
		this.name="H";
		salaX = sx;
		salaY = sy;
		armas=w;
		armaduras=a;
		pocoes=p;
		attack=3;
		mind=8;

	}
	
	public void mudarNome (String nome) {
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

	public int getHP() {
		return this.body;
	}

	public int getAttackDices() {
		return this.attack;
	}

	public int getDeffensDices() {
		return this.deffense;
	}

	public int getIntelligence() {
		return this.mind;
	}
	public void increaseBodyPoints (int cura) {
		this.body=this.body+cura;		
	}
	
	public void increaseAttackDices (int fortalece) {
		this.attack=this.attack+fortalece;		
	}
	
	public void increaseDeffenseDices (int protege) {
		this.deffense=this.deffense+protege;		
	}
	
	public void increaseMindPoints (int ensina) {
		this.mind=this.mind+ensina;		
	}
	
	//Bebe Po��es
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
