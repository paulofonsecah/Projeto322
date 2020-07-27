package mapElement.herois;

import java.util.ArrayList;


import itens.Armor;
import itens.Item;
import itens.armas.*;
import itens.potions.Potions;
import mapElement.*;

public class Heroi extends Personagem {
	
	public String name;


	protected int deffense;
	protected int mind;
	protected int freeHands; //0-2
	
	
	protected ArrayList<Armor> armaduras; //MAX 2 COMO SETAR?
	protected ArrayList<Potions> pocoes;
	
	public ArrayList<Item> bolsa;
	
	protected int salaY;
	protected int salaX;
	
	public Heroi(int px, int py) { //COORDENADAS?? ArrayList<Armas> w, ArrayList<Armor> a,
		
		super(px,py);
		
		this.name="H";
		
	}
	
	public void setSalaY(int salaY) {
		this.salaY = salaY;
	}

	public int getSalaY() {
		return salaY;
	}
	
	public int getSalaX() {
		return salaX;
	}

	public void setSalaX(int salaX) {
		this.salaX = salaX;
	}

	
	public void mudarNome (String nome) {
		this.name=nome;
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
	
	public void usarArma(int posBolsa) {
		Armas armaUsar = (Armas)this.bolsa.get(posBolsa); 
		if(this.freeHands - armaUsar.ocupaMaos>=0) {
			this.armas.add(armaUsar);
			this.freeHands =- armaUsar.ocupaMaos;
			this.bolsa.remove(posBolsa);
		}
	}
	
	public int getFreeHands() {
		return this.freeHands;
	}
	
	public void releaseHands() {}


	public int getAttackDices() {
		return this.attack;
	}

	public int getDeffensDices() {
		return this.deffense;
	}

	public int getIntelligence() {
		return this.mind;
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

	public void decreaseAttackDices (int enfraquece) {
		this.attack=this.attack-enfraquece;		
	}

	public void decreaseDeffenseDices (int dano) {
		this.deffense=this.deffense-dano;		
	}
	
	public void decreaseMindPoints (int dano) {
		this.mind=this.mind-dano;		
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
