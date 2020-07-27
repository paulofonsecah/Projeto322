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
	
	
	protected ArrayList<Potions> pocoes;
	protected ArrayList<Armas> armas;
	
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



	public int getAttack() {
		return this.attack;
	}

	public int getDeffense() {
		return this.deffense;
	}

	public int getMind() {
		return this.mind;
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

	public void decreaseAttackDices (int enfraquece) {
		this.attack=this.attack-enfraquece;		
	}

	public void decreaseDeffenseDices (int dano) {
		this.deffense=this.deffense-dano;		
	}
	
	public void decreaseMindPoints (int dano) {
		this.mind=this.mind-dano;		
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
