package itens.magias;
import itens.Item;
import mapElement.Personagem;


public interface Magia extends Item {
	
	public void ehUsada(Personagem personagem);
}
