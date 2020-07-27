package mapElement.monstros;

import java.util.ArrayList;

import itens.armas.Armas;
import itens.armas.Punhal;

public class Esqueleto extends Monster{
	
	Punhal punhal =new Punhal();

	public Esqueleto(ArrayList<Armas> w, int x, int y) {
		super(x,y);
		
		this.body=2;
		this.attack=1;		
		
		this.armas.add(punhal);
	}
}
