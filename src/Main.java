import java.util.ArrayList;
import java.util.Scanner;
import Itens.*;
import Itens.potions.*;
import itens.potions.EnlightenPot;
import itens.potions.HealPot;
import itens.potions.Potions;
import itens.potions.StrenghtenPot;
import mapElement.Treasures;
import mapElement.herois.Heroi;

public class Main {
	
	public static void main(String[] args) {
		
		StrenghtenPot forca= new StrenghtenPot();
		HealPot saude= new HealPot();
		EnlightenPot intelig= new EnlightenPot();
		
		ArrayList<Potions> pocoes = new ArrayList<Potions>();
		pocoes.add(intelig);
		pocoes.add(forca);
		pocoes.add(saude);
        
		//Treasures tesouro =new Treasures(pocoes, 1, 2);
		
		//ArrayList<Item> conteudo = tesouro.pegarTudo();
		
		System.out.println("tesouro da mamãe");
		
		Heroi kiko = new Heroi(pocoes, 1, 2);
		
		StrenghtenPot forca1= new StrenghtenPot();
		
		kiko.drinkPotion(forca);
		
		System.out.println("tesouro da mamãe");
	
	}	
        
}
      
