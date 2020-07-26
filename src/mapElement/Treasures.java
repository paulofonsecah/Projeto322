package mapElement;
import Itens.Item;
import java.util.ArrayList;

public class Treasures extends MapElement{
	
	private ArrayList<Item> content;
	
	public Treasures(ArrayList<Item> conteudo, int x, int y) {
		super(x,y);
		this.content=conteudo;		
	}
	
	public ArrayList<Item> pegarTudo () {
		ArrayList<Item>	aux = this.content;
		this.content=new ArrayList<Item>(); //esvazia a bolsa
		return aux; //lista o conteúdo
	}
	

}
