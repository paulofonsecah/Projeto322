package game;

import Itens.Armas;
import Itens.Item;
import Itens.magias.Magia;
import Itens.magias.MagicMissile;
import mapElement.*;
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
	
	
	public void moveHeroi(int x, int y) {
		if (mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY() + y][hero.getX() + x] instanceof Monster) {
			System.out.print("Não é possivel se mover nesta direção. Motivo: há um monstro nela  \n");
		} else if (mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY() + y][hero.getX() + x] instanceof Door) {
			System.out.printf("Deseja acessar a porta? Pressione 'e' \n");
		} else if (mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY() + y][hero.getX() + x] instanceof Treasures) {
			System.out.printf("Não é possivel se mover nesta direção. Motivo: há um tesouro nela  \n");
		} else if (hero.getY() + y >= 4 || hero.getX() + x >= 4 || hero.getY() + y <= 0 || hero.getX() + x <= 0) {
			System.out.printf("Não é possivel se mover nessa direção. Motivo: parede \n");
		} else {
			hero.setX(hero.getX() + x);
			hero.setY(hero.getY() + y);
			mapa.map[hero.getSalaY()][hero.getSalaX()].setHero(hero);

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
				hero.setX(0);
				hero.setY(mapa.map[hero.getSalaX()+x][hero.getSalaY()+y].getX()-1);
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
	public void atacarMostro(int x, int y){
		if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement(hero.getX()+x,hero.getY()+y) instanceof Monster){
			Dado dadoHeroi = new Dado();
			ArrayList<Integer> dados =dadoHeroi.rolarDadoAttack(hero.getAttackDices());
			Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement(hero.getX() + x, hero.getY() + y);
			monster.setBody(monster.getBody()-dados.get(0)-dados.get(2));
			if(monster.getBody()<=0){
				Empty vasio =new Empty(hero.getX()+x,hero.getY()+y);
				mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(hero.getX()+x,hero.getY()+y,vasio);
			}else{
				mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(hero.getX()+x,hero.getY()+y,monster);
			}
		}else{
			System.out.println("ops isso nao eh um mostro");
		}
	}
	public void lancarMagicaMostro(int x, int y){
		if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement(hero.getX()+x,hero.getY()+y) instanceof Monster){
			Dado dadoHeroi = new Dado();
			ArrayList<Integer> dados =dadoHeroi.rolarDadoAttack(hero.getAttackDices());
			Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement(hero.getX() + x, hero.getY() + y);
			monster.setBody(monster.getBody()-dados.get(0)-dados.get(2));
			if(monster.getBody()<=0){
				Empty vasio =new Empty(hero.getX()+x,hero.getY()+y);
				mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(hero.getX()+x,hero.getY()+y,vasio);
			}else{
				mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(hero.getX()+x,hero.getY()+y,monster);
			}
		}else{
			System.out.println("ops isso nao eh um mostro");
		}
	}

	public void lansarMagia(int x, int y, Magia m){
		if(x==0 && y==1){
			for(int i=hero.getY();i>=0;i--){
				if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( hero.getX(), i) instanceof Monster){
					Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( hero.getX(), i);
					Dado dadoHeroi = new Dado();
					int dado=dadoHeroi.rolarDado();
					if(dado<hero.getIntelligence()){
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
						}
						if(monster.getBody()<=0){
							Empty vasio =new Empty(hero.getX(), i);
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(hero.getX(), i,vasio);
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
					if(dado<hero.getIntelligence()){
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
						}
						if(monster.getBody()<=0){
							Empty vasio =new Empty(hero.getX(), i);
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(hero.getX(), i,vasio);
						}else{
							mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(hero.getX(), i,monster);
						}
					}

				}
			}
		}else if(x==1 && y==0){
			for(int i=hero.getX();i<mapa.map[hero.getSalaX()][hero.getSalaY()].getX();i++){
				if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY()) instanceof Monster){
					Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY());
					Dado dadoHeroi = new Dado();
					int dado=dadoHeroi.rolarDado();
					if(dado<hero.getIntelligence()){
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
						}
						if(monster.getBody()<=0){
							Empty vasio =new Empty(i,hero.getY());
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(i,hero.getY(),vasio);
						}else{
							mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(i,hero.getY(),monster);
						}
					}

				}
			}
		}else if(x==-1 && y==0){
			for(int i=hero.getX();i>=0;i--){
				if(mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY()) instanceof Monster){
					Monster monster = (Monster) mapa.map[hero.getSalaX()][hero.getSalaY()].getMapElement( i, hero.getY());
					Dado dadoHeroi = new Dado();
					int dado=dadoHeroi.rolarDado();
					if(dado<hero.getIntelligence()){
						if(m instanceof MagicMissile){
							monster.setBody(monster.getBody()-6);
						}
						if(monster.getBody()<=0){
							Empty vasio =new Empty(i,hero.getY());
							mapa.map[hero.getSalaY()][hero.getSalaX()].setMapElement(i,hero.getY(),vasio);
						}else{
							mapa.map[hero.getSalaX()][hero.getSalaY()].setMapElement(i,hero.getY(),monster);
						}
					}

				}
			}
		}
	}

	public void mostrarItem(int x, int y) {
		int i=1;
		for (Item o : hero.bolsa) {
			if(o instanceof Armas){
				Armas a = (Armas) o;
				System.out.println(i+a.getNome());
			}

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