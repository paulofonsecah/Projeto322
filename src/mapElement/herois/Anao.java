package mapElement.herois;

import itens.armas.*;

public class Anao extends Heroi {
	
	EspadaCurta espadaCurta =new EspadaCurta();
	Punhos punhos = new Punhos(); 
	
	public Anao(int px, int py) {
		
		super(px, py);
		
		this.name="D";
		this.attack=2;
		this.deffense=2;
		this.mind=3;
		this.body=7;
		
		this.freeHands=0;
		
		this.bolsa.add(espadaCurta);
		this.armas.add(punhos);
	}

}
