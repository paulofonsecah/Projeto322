package game;

import mapElement.Door;
import mapElement.Empty;
import mapElement.Map;
import mapElement.Treasures;
import mapElement.herois.Heroi;
import mapElement.monstros.Monster;

import java.util.ArrayList;

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
	
	
	public int moveHeroi(int x, int y){
		if((hero.getY() >=4 && y== 1)|| (hero.getX() >=4 && x== 1) || (hero.getY() <=0 && y== -1) || (hero.getX() <=0 && x== -1)){
        	System.out.printf("Não é possivel se mover nessa direção. Motivo: parede \n");
        	return 0;
		}else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+y][hero.getX()+x] instanceof Monster) {
        	System.out.print("Não é possivel se mover nesta direção. Motivo: há um monstro nela  \n");
        	return 0;
        }
        
        else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+y][hero.getX()+x] instanceof Treasures){
            System.out.printf("Não é possivel se mover nesta direção. Motivo: há um tesouro nela  \n");	
            return 0;
           }
      /*  else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+y][hero.getX()+x] instanceof Trap){
        	int aleatNum;
        	aleatNum = ThreadLocalRandom.current().nextInt(1, 2);
            if(aleatNum == 1) {
            	System.out.printf("Você caiu em uma armadilha e recebeu 2 de dano\n");
            	hero.setBody (hero.getBody - 2);
            	return 0;
            }
            else{
            System.out.printf("Você ficou preso em uma armadilha e não pode se mover nesse turno\n");
            return 2;
            }
        }*/
	    else{
	    	mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setX(hero.getX()+x); 
	        hero.setY(hero.getY()+y); 
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
	        return 1;
	 }
}

	public int abrirPorta() {
		if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+1][hero.getX()] instanceof Door) {
			mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setY(1); 
	        hero.setSalaY(hero.getSalaY()+1);
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()+1] instanceof Door) {
			mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setX(1); 
	        hero.setSalaX(hero.getSalaX()+1);
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()-1] instanceof Door) {
			mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setX(1); 
	        hero.setSalaX(hero.getSalaX()-1);
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()-1][hero.getX()] instanceof Door) {
			mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setY(1); 
	        hero.setSalaY(hero.getSalaY()-1);
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
		}
		return 0;
	}
	
	public void atacarMostro(){
		int dano, vida;
		if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+1][hero.getX()] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+1][hero.getX()] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()-1][hero.getX()] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()-1][hero.getX()] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()+1] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()+1] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()-1] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()-1] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else {
			System.out.printf("Nenhum monstro proximo.");
		}

	}

	public void lancarMagia(int x, int y){
		if(x==0 && y==1){
		}else if(x==0 && y==-1){
		}else if(x==1 && y==0){
		}else if(x==-1 && y==0){
		}
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

