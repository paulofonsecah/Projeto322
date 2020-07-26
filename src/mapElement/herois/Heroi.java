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
	
	public ArrayList<Armas> armas;
	public ArrayList<Armor> armaduras; //MAX 2 COMO SETAR?
	public ArrayList<Potions> pocoes;
	
	public ArrayList<Item> bolsa;
	
	public int Sala;
	
	public Heroi(ArrayList<Armas> w, ArrayList<Armor> a, ArrayList<Potions> p,  int px, int py) { //COORDENADAS?? ArrayList<Armas> w, ArrayList<Armor> a,
		
		super(px,py);
		
		this.name="H";
		
		armas=w;
		armaduras=a;
		pocoes=p;
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
	
	
	public void increaseBodyPoints (int cura) {
		this.body=this.body+cura;		
	}
	
	public void increaseAttackDices (int fortalece) {
		this.body=this.body+fortalece;		
	}
	
	public void increaseDeffenseDices (int protege) {
		this.body=this.body+protege;		
	}
	
	public void increaseMindPoints (int ensina) {
		this.body=this.body+ensina;		
	}
	
	//Bebe Poçôes
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
