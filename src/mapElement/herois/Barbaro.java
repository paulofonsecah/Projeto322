package mapElement.herois;

import itens.armas.*;

public class Barbaro extends Heroi{
	
	EspadaLonga espadaLonga =new EspadaLonga();
	Punhos punhos = new Punhos(); 
	
	public Barbaro(int px, int py) {
		super(px,py);
		
		this.name="B";
		this.attack=3;
		this.deffense=2;
		this.mind=2;
		this.body=8;
		
		this.freeHands=0;
		
		this.bolsa.add(espadaLonga);
		
		this.armas.add(punhos);
	}
	

}
