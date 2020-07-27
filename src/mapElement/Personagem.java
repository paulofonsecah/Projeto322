package mapElement;

import java.util.ArrayList;

import Itens.Armas;

public class Personagem extends MapElement{
	
	protected int attack;
	protected int body; //H
	public ArrayList<Armas> armas;
	
	public Personagem(int x,int y){
		super(x,y);
	}

	public ArrayList<Armas> getArmas(){
		return armas;
	}	
		
	public void setArmas(ArrayList<Armas> arma) { 
		this.armas=arma;
	}
	
	
	public int getBody() {
		return this.body;
	}
	
	public void increaseBodyPoints (int cura) {
		this.body=this.body+cura;		
	}
	
	public void decreaseBodyPoints (int dano) {
		this.body=this.body-dano;		
	}
	
}
