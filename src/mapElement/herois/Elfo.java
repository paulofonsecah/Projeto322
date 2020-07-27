package mapElement.herois;



import java.util.ArrayList;
import itens.armas.*;
import itens.magias.*;

public class Elfo extends Heroi{
	
	public ArrayList<Magia> magias;
	SimpleHeal simpleHeal = new SimpleHeal();
	EspadaCurta espadaCurta =new EspadaCurta();
	Punhos punhos = new Punhos(); 
	
	public Elfo(int px, int py) {
		super(px,py);
		
		this.name="E";
		this.attack=2;
		this.deffense=2;
		this.mind=4;
		this.body=6;
		
		this.magias.add(simpleHeal);
		
		this.freeHands=0;
		
		this.armas.add(punhos);
		this.bolsa.add(espadaCurta);
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