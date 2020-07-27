package game;
import Itens.magias.MagicMissile;
import mapasDefaut.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Itens.Armas;
import Itens.Armor;
import Itens.potions.Potions;
import mapElement.Map;
import mapElement.herois.Heroi;
import mapElement.monstros.Monster;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Map mapa1  =new Map(4,4);
		final Mapa2 mapas = new Mapa2();
	
		
		ArrayList<Armas> w = new ArrayList<Armas>();
		ArrayList<Armor> a = new ArrayList<Armor>();
		ArrayList<Potions> p = new ArrayList<Potions>();
		
		Heroi hero = new Heroi(w, a, p,1,1,3,3); //Posicao do Heroi: (3,3) na sala (1,1)
		Monster monster;
        mapa1 = mapas.criarMapa(mapa1,hero);
        //mapa1.imprimeMap();
		//mapa1.imprimeMap();
		Scanner keyboard = new Scanner ( System .in);
		Action mov;
		int turno = 0, energia, acao, movimento, sucesso ;
		Dado dadoHeroi = new Dado();
		boolean running = true ;
		
		
        while ( running ) { 
        	turno += 1;
        	acao = 0; movimento = 0;
        	while (acao != 1 || movimento != 1){  		
        	if(acao == 0 && movimento == 0){
        		System.out.printf("Turno %d\nAcoes disponiveis: e - interagir; a - atacar; q - usar magias; i - abrir inventario; m - mover; p - abrir porta; f - sair do jogo\n", turno);
        	}
        	else if(acao == 1){
        		System.out.printf("Turno %d\nAcoes disponiveis:i - abrir inventario; m - mover; p - abrir porta; f - sair do jogo\n", turno);
        	}
        	else if(movimento == 1){
        		System.out.printf("Turno %d\nAcoes disponiveis: e - interagir; a - atacar; q - usar magias; i - abrir inventario; p - abrir porta; f - sair do jogo\n", turno);
        	}
        	String command = keyboard.nextLine ();
            if (command.compareTo("f") == 0) {
            	System.out.println("Game Over");             	
                running = false ;
            } 
            else if(command.compareTo("p") == 0){
                System.out.printf("Onde esta a porta: w - cima; a - esquerda; s - baixo; d - direita; p - parar\n");
                command = keyboard.nextLine ();
                if (command.compareTo ("s") == 0) {
                    //heroi.moveHeroiVertical(-1);
                    mov = new Action(mapa1, hero);
                    mov.abrirPorta(1, 0);
                    mapa1.imprimeMap();
                } else if ( command . compareTo ("a") == 0) {
                    mov = new Action(mapa1, hero);
                    mov.abrirPorta(0, -1);
                    mapa1.imprimeMap();
                } else if ( command . compareTo ("w") == 0) {
                    mov = new Action(mapa1, hero);
                    mov.abrirPorta(-1, 0);
                    mapa1.imprimeMap();
                } else if ( command . compareTo ("d") == 0) {
                    mov = new Action(mapa1, hero);
                    mov.abrirPorta(0, 1);
                    mapa1.imprimeMap();
                }
            }
            else if(command.compareTo("i") == 0){
                mov = new Action(mapa1, hero);
                ArrayList<Armas> armas = mov.mostrarItem();
                if(armas.size()>0){
                    System.out.println("Deseja usar um item ? se sim digite o numero se nao digite n");
                     command = keyboard.nextLine ();
                    if(command.compareTo("n") != 0 ){


                    }



                }
            }
            else if(command.compareTo("m") == 0 && movimento == 1){
            	System.out.println("So e possivel rolar o dado de movimento uma vez por turno");   
            }
            else if(command.compareTo("m") == 0 && movimento == 0){
            	energia = dadoHeroi.rolarDado(2);
            	while(energia>0){
            		sucesso = 0;
            		System.out.printf("Movimentos possiveis: %d\nAcoes disponiveis: w - cima; a - esquerda; s - baixo; d - direita; p - parar\n", energia);
                    command = keyboard.nextLine ();
                    if (command.compareTo ("s") == 0) {
                    	mov = new Action(mapa1, hero);
                    	sucesso = mov.moveHeroi(1, 0);                        
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                        else if(sucesso == 2) energia = 0;
                    } else if ( command . compareTo ("a") == 0) {
                        mov = new Action(mapa1, hero);
                        sucesso = mov.moveHeroi(0, -1);
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                        else if(sucesso == 2) energia = 0;
                    } else if ( command . compareTo ("w") == 0) {
                        mov = new Action(mapa1, hero);
                        sucesso = mov.moveHeroi(-1, 0);
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                        else if(sucesso == 2) energia = 0;
                    } else if ( command . compareTo ("d") == 0) {
                        mov = new Action(mapa1, hero);
                        sucesso = mov.moveHeroi(0, 1);
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                        else if(sucesso == 2) energia = 0;
                    }
                    else if ( command . compareTo ("e") == 0) {
                    	mov = new Action(mapa1, hero);
                    	mapa1.imprimeMap();
                    }
                    else if ( command . compareTo ("p") == 0) {
                        energia = 0;
                    }
            	}   
            	movimento=1;
            }
            else if(command.compareTo("a") == 0 && acao != 0){
            	System.out.println("So e possivel atacar uma vez por turno");   
            }
            else if(command.compareTo("a") == 0 && acao == 0){
            	acao = 1;
            	int heroy1, herox1, heroy2, herox2;
        		heroy1=hero.getY()+1; heroy2=hero.getY()-1; herox1=hero.getX()+1; herox2=hero.getX()-1; 
        		if(heroy1>4) heroy1=4;
        		if(heroy2<0) heroy2=0;
        		if(herox1>4) herox1=4;
        		if(herox2<0) herox2=0;
                System.out.printf("Atacar com : a - arma; m - magia\n");
                command = keyboard.nextLine ();
                if (command.compareTo ("a") == 0) {
                	if(mapa1.map[hero.getSalaY()][hero.getSalaX()].room[heroy1][hero.getX()] instanceof Monster) {                		
                		monster = (Monster) mapa1.map[hero.getSalaX()][hero.getSalaY()].room[heroy1][hero.getX()];        		mov = new Action(mapa1, hero, monster);
                		mov.atacarMostro();
                	}
                	else if(mapa1.map[hero.getSalaY()][hero.getSalaX()].room[heroy2][hero.getX()] instanceof Monster) {
                		monster = (Monster) mapa1.map[hero.getSalaX()][hero.getSalaY()].room[heroy2][hero.getX()];        		mov = new Action(mapa1, hero, monster);
                		mov.atacarMostro();
                	}
                	else if(mapa1.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][herox1] instanceof Monster) {
                		monster = (Monster) mapa1.map[hero.getSalaX()][hero.getSalaY()].room[hero.getY()][herox1];        		mov = new Action(mapa1, hero, monster);
                		mov.atacarMostro();
                	}
                	else if(mapa1.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][herox2] instanceof Monster) {
                		monster = (Monster) mapa1.map[hero.getSalaX()][hero.getSalaY()].room[hero.getY()][herox2];        		mov = new Action(mapa1, hero, monster);
                		mov.atacarMostro();
                	}
            		else {
            			System.out.printf("Nenhum monstro proximo.\n");
            		}
                	
                }
                else if(command.compareTo ("m") == 0){
                    System.out.printf("Onde esta o mostro: w - cima; a - esquerda; s - baixo; d - direita; p - parar\n");
                    command = keyboard.nextLine ();
                    if (command.compareTo ("s") == 0) {
                        mov = new Action(mapa1, hero);
                        MagicMissile m= new MagicMissile();
                        mov.lancarMagia(1, 0,m);
                    } else if ( command . compareTo ("a") == 0) {
                        mov = new Action(mapa1, hero);
                        MagicMissile m= new MagicMissile();
                        mov.lancarMagia(0, 1,m);
                    } else if ( command . compareTo ("w") == 0) {
                        mov = new Action(mapa1, hero);
                        MagicMissile m= new MagicMissile();
                        mov.lancarMagia(-1, 0,m);
                    } else if ( command . compareTo ("d") == 0) {
                        mov = new Action(mapa1, hero);
                        MagicMissile m= new MagicMissile();
                        mov.lancarMagia(0, -1,m);
                    }
                }
                mapa1.imprimeMap();
            }
            else if(command.compareTo ("p") == 0){
            	System.out.println("Turno encerrado"); 
            	acao = 1; movimento = 1;
            }            
            

            }	
    	}		
 
	}
      
}