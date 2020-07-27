package mapElement.herois;


import java.util.ArrayList;

import itens.armas.*;
import itens.magias.*;

public class Feiticeiro extends Heroi{
	
	public ArrayList<Magia> magias;
	MagicMissile magicMissile1 = new MagicMissile();
	MagicMissile magicMissile2 = new MagicMissile();
	MagicMissile magicMissile3 = new MagicMissile();
	Teleport teleport  = new Teleport();
	
	Punhal punhal1 =new Punhal();
	Punhal punhal2 =new Punhal();
	Punhal punhal3 =new Punhal();
	Punhos punhos = new Punhos(); 
	
	
    public Feiticeiro(int px, int py) {
		
		super(px, py);
		
		this.name="W";
		this.attack=1;
		this.deffense=2;
		this.mind=6;
		this.body=4;
		
		this.bolsa.add(punhal1);
		this.bolsa.add(punhal2);
		this.bolsa.add(punhal3);
		
		this.magias.add(magicMissile1);
		this.magias.add(magicMissile2);
		this.magias.add(magicMissile3);
		this.magias.add(teleport);
		
		this.freeHands=0;
		this.armas.add(punhos);
		
	}

	public ArrayList<Magia> getMagias(){
	return magias;
	}
	
	public void setMagias(ArrayList<Magia> magia) {
		this.magias=magia;	

	}
	
	public void castSpell (Magia magia) {
		boolean status=false;	
		for( Magia o : this.magias ) {
			if(o.getClass()==magia.getClass()) {
				status=true;
			}
		}
		if(status) {
			magia.ehUsada(this);
			this.magias.remove(magia);
		}
	}

}