package game;

import mapElement.Empty;
import mapElement.Map;
import mapElement.herois.Heroi;
import mapElement.monstros.Monster;

public class Action {
	Map mapa;
	Heroi hero;
	Monster monster;
	
	public Action(Map mapa, Heroi hero, Monster monstro) {
		this.mapa = mapa;
		this.hero = hero;	
		this.monster = monstro;
	}
	
	public Action(Map mapa, Heroi hero) {
		this.mapa = mapa;
		this.hero = hero;	
		this.monster = null;
	}
	
	
	public void moveHeroi(int x, int y){
        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
        hero.setX(hero.getX()+x); 
        hero.setY(hero.getY()+y); 
        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;	
	}
	
	
	
	/*
	public int heal(){
		if (hero.name != "Elfo"){
			System.out.println("Sua classe n�o possui essa magia!");
			return 0;
		}
		else{
			Dado dice = new Dado(6);
			int cura;
			cura = dice.rolarDado(1);
			hero.setBody(hero.getBody + cura);
			System.out.printf("Voc� se curou em %d!\n", cura);
			return 1; 		
		}
	}
	
	public int magicMissile(){
		if (hero.name != "Feiticeiro"){
			System.out.println("Sua classe n�o possui essa magia!");
			return 0;
		}
		else if(monster.name == "Null"){
			System.out.println("Nenhum monstro pr�ximo!");
			return 0;
		}
		else {
			monster.setBody(monster.getBody - 6);
			System.out.println("Voc� disparou 3 misseis m�gicos no alvo, causando 2 de dano cada!");
			return 1; 
		}
		
	}
	*/
	
	
	
	
}
