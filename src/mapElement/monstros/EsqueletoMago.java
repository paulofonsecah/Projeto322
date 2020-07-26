package mapElement.monstros;
import java.util.ArrayList;
import magias;
import itens.armas.Armas;
import Monster;

public class EsqueletoMago extends Monster {
	
	public ArrayList<Magia> magias;
	
	public EsqueletoMago(ArrayList<Armas> w, public ArrayList<Magia> s, int x, int y) {
		super(w,x,y);
		
		this.body=3;
		this.attack=2;		
		
		this.magias=s;
	}
	

public ArrayList<Magia> getMagias(){
	return magias;
}	
	
public void setMagias (ArrayList<Magias> magias) { 
	this.magias = magias;
}


}