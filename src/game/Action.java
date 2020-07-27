package game;

import Itens.Armas;
import Itens.Item;
import Itens.magias.Magia;
import Itens.magias.MagicMissile;
import mapElement.*;
import mapElement.herois.Heroi;
import mapElement.monstros.Monster;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
        else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+y][hero.getX()+x] instanceof Trap){
        	int aleatNum;
        	aleatNum = ThreadLocalRandom.current().nextInt(1, 3);
            if(aleatNum == 1) {
            	System.out.printf("Você caiu em uma armadilha e recebeu 2 de dano\n");
            	hero.setBody(hero.getBody() - 2);
            	System.out.printf("Sua vida atual é: %d\n", hero.getBody());
    	    	mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
    	        hero.setX(hero.getX()+x); 
    	        hero.setY(hero.getY()+y); 
    	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
            	return 0;
            }
            else{
            System.out.printf("Você ficou preso em uma armadilha e não pode mais se mover nesse turno\n");
	    	mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setX(hero.getX()+x); 
	        hero.setY(hero.getY()+y); 
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
            return 2;
            }
        }
	    else{
	    	mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setX(hero.getX()+x); 
	        hero.setY(hero.getY()+y); 
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
	        return 1;
	 }
}

	public void abrirPorta(int x, int y){
		if(mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].getMapElement(hero.getX(),hero.getY()) instanceof Door){
			mapa.map[hero.getSalaY()][hero.getSalaX()].setHero(null);
			if(x==0 && y==1){
				hero.setX(hero.getX());
				hero.setY(0);
				mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].setHero(hero);
				hero.setSalaX(hero.getSalaX()+x);
				hero.setSalaY(hero.getSalaY()+y);
			}else if(x==0 && y==-1){
				hero.setX(hero.getX());
				hero.setY(mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].getY()-1);
				mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].setHero(hero);
				hero.setSalaX(hero.getSalaX()+x);
				hero.setSalaY(hero.getSalaY()+y);
			}else if(x==-1 && y==0){
				hero.setX(mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].getX()-1);
				hero.setY(hero.getY());
				mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].setHero(hero);
				hero.setSalaX(hero.getSalaX()+x);
				hero.setSalaY(hero.getSalaY()+y);
			}else if(x==1 && y==0){
				hero.setX(0);
				hero.setY(hero.getY());
				mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].setHero(hero);
				hero.setSalaX(hero.getSalaX()+x);
				hero.setSalaY(hero.getSalaY()+y);
			}
		}else{
			System.out.println("ops isso nao eh um porta");
		}
	}
	public void atacarMostro(){
		int dano, vida;
		int heroy1, herox1, heroy2, herox2;
		heroy1=hero.getY()+1; heroy2=hero.getY()-1; herox1=hero.getX()+1; herox2=hero.getX()-1; 
		if(heroy1>4) heroy1=4;
		if(heroy2<0) heroy2=0;
		if(herox1>4) herox1=4;
		if(herox2<0) herox2=0;
		if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[heroy1][hero.getX()] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[heroy1][hero.getX()] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[heroy2][hero.getX()] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[heroy2][hero.getX()] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][herox1] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][herox1] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][herox2] instanceof Monster) {
			Dado dice = new Dado();
			dano = dice.rolarDadoAttack(0, hero.getAttack(), monster.getDeffense());
			vida = monster.getBody()-dano;
			monster.setBody(vida);
			if (vida<=0) {
				System.out.printf("Monstro eliminado!\n");
				mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][herox2] = new Empty(0,0);
			}
			else {
				System.out.printf("Vida restante do monstro: %d\n", vida);
			}
		}
		else {
			System.out.printf("Nenhum monstro proximo.");
		}

	}


	public void lancarMagia(int x, int y, Magia m){
		if(x==0 && y==1){
			for(int i=hero.getY();i>=0;i--){
				if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( hero.getX(), i) instanceof Monster){
					Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( hero.getX(), i);
					Dado dadoHeroi = new Dado();
					int dado=dadoHeroi.rolarDado();
					System.out.printf("Inteligência do Heroi: %d\nInteligência do monstro: %d\n", hero.getMind(), monster.getMind());
					if(dado<hero.getMind() || dado<monster.getMind()){
						System.out.printf("Magia lançada com sucesso!\n");				
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
							System.out.printf("Você disparou 3 misseis mágicos no monstro, causando 2 de dano cada\nVida restante do monstro: %d\n", monster.getBody());
						}
						if(monster.getBody()<=0){
							System.out.printf("Monstro eliminado!\n");
							Empty vazio =new Empty(hero.getX(), i);
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(hero.getX(), i,vazio);
						}else{
							mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(hero.getX(), i,monster);
						}
					}

				}
			}
		}else if(x==0 && y==-1){
			for(int i=hero.getY();i<mapa.map[hero.getSalaX()][hero.getSalaY()].getY();i++){
				if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( hero.getX(), i) instanceof Monster){
					Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( hero.getX(), i);
					Dado dadoHeroi = new Dado();
					int dado=dadoHeroi.rolarDado();
					System.out.printf("Inteligência do Heroi: %d\nInteligência do monstro: %d\n", hero.getMind(), monster.getMind());
					
					if(dado<hero.getMind() || dado<monster.getMind()){
						System.out.printf("Magia lançada com sucesso!\n");
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
							System.out.printf("Você disparou 3 misseis mágicos no monstro, causando 2 de dano cada\nVida restante do monstro: %d\n", monster.getBody());
						}
						if(monster.getBody()<=0){
							System.out.printf("Monstro eliminado!\n");
							Empty vazio =new Empty(hero.getX(), i);
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(hero.getX(), i,vazio);
						}else{
							mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(hero.getX(), i,monster);
						}
					}
					else{
						System.out.printf("A magia falhou.\n");
					}

				}
			}
		}else if(x==1 && y==0){
			for(int i=hero.getX();i<mapa.map[hero.getSalaX()][hero.getSalaY()].getX();i++){
				if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY()) instanceof Monster){
					Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY());
					Dado dadoHeroi = new Dado();
					int dado=dadoHeroi.rolarDado();
					System.out.printf("Inteligência do Heroi: %d\nInteligência do monstro: %d\n", hero.getMind(), monster.getMind());
					
					if(dado<hero.getMind() || dado<monster.getMind()){
						System.out.printf("Magia lançada com sucesso!\n");		
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
							System.out.printf("Você disparou 3 misseis mágicos no monstro, causando 2 de dano cada\nVida restante do monstro: %d\n", monster.getBody());

						}
						if(monster.getBody()<=0){
							System.out.printf("Monstro eliminado!\n");
							Empty vazio =new Empty(i,hero.getY());
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(i,hero.getY(),vazio);
						}else{
							mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(i,hero.getY(),monster);
						}
					}
					else{
						System.out.printf("A magia falhou.\n");						
					}

				}
			}
		}else if(x==-1 && y==0){
			for(int i=hero.getX();i>=0;i--){
				if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY()) instanceof Monster){
					Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY());
					Dado dadoHeroi = new Dado();
					int dado=dadoHeroi.rolarDado();
					System.out.printf("Inteligência do Heroi: %d\nInteligência do monstro: %d\n", hero.getMind(), monster.getMind());
					
					if(dado<hero.getMind() || dado<monster.getMind()){
						System.out.printf("Magia lançada com sucesso!\n");		
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
							System.out.printf("Você disparou 3 misseis mágicos no monstro, causando 2 de dano cada\nVida restante do monstro: %d\n", monster.getBody());

						}
						if(monster.getBody()<=0){
							System.out.printf("Monstro eliminado!\n");
							Empty vazio =new Empty(i,hero.getY());
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(i,hero.getY(),vazio);
						}else{
							mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(i,hero.getY(),monster);
						}
					}
					else{
						System.out.printf("A magia falhou.\n");
					}

				}
			}
		}
	}
	public ArrayList<Armas> mostrarItem() {
		int i=1;
		ArrayList<Armas> armas= new ArrayList<Armas>();
		for(Item o : hero.bolsa){
			if(o instanceof Armas){
				Armas arma = (Armas) o;
				armas.add(arma);
				System.out.println(i+"- "+arma.getName());
			}
		}
		return armas;
	}
	public void pegarItem(int i) {
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

