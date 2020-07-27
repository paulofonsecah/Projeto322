package mapElement.monstros;
import java.util.ArrayList;
import itens.magias.*;
import itens.armas.*;

public class EsqueletoMago extends Monster {
	
	public ArrayList<Magia> magias;
	MagicMissile magicMissile = new MagicMissile();
	Punhos punhos = new Punhos(); 
	
	public EsqueletoMago(int x, int y) {
		super(x,y);
		
		this.body=3;
		this.attack=2;		

		this.magias.add(magicMissile);
		
		this.armas.add(punhos);
	}
	

	public ArrayList<Magia> getMagias(){
		return magias;
	}	
	
	public void setMagias (ArrayList<Magia> magias) { 
		this.magias = magias;
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
	}
	}
}


