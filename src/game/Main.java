package game;
import mapasDefaut.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Itens.Armas;
import Itens.Armor;
import Itens.potions.Potions;
import mapElement.Map;
import mapElement.herois.Heroi;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Map mapa1  =new Map(4,4);
		final Mapa2 mapas = new Mapa2();
	
		
		ArrayList<Armas> w = new ArrayList<Armas>();
		ArrayList<Armor> a = new ArrayList<Armor>();
		ArrayList<Potions> p = new ArrayList<Potions>();
		
		Heroi hero = new Heroi(w, a, p,1,1,3,3); //Posi��o inicial do Heroi: (3,3) na sala (1,1)
        mapa1 = mapas.criarMapa(mapa1,hero);
        //mapa1.imprimeMap();
		//mapa1.imprimeMap();
		Scanner keyboard = new Scanner ( System .in);
		Action mov;
		int turno = 1;
		Dado dadoHeroi = new Dado();
		int energia;
		boolean running = true ;
        while ( running ) {
        
        	System.out.printf("Turno %d \n Acoes disponiveis: e - interagir; a - atacar; m - mover;  p - abrir porta; f - sair\n", turno);
            String command = keyboard.nextLine ();
            if ( command . compareTo ("f") == 0) {
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
            else if(command.compareTo("a") == 0){
                System.out.printf("Com : a- arma m -magica\n");
                command = keyboard.nextLine ();
                System.out.printf("Onde esta o mostro: w - cima; a - esquerda; s - baixo; d - direita; p - parar\n");
                if (command.compareTo ("a") == 0) {
                    if (command.compareTo ("s") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.atacarMostro(1, 0);
                        mapa1.imprimeMap();
                    } else if ( command . compareTo ("a") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.atacarMostro(0, -1);
                        mapa1.imprimeMap();
                    } else if ( command . compareTo ("w") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.atacarMostro(-1, 0);
                        mapa1.imprimeMap();
                    } else if ( command . compareTo ("d") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.atacarMostro(0, 1);
                        mapa1.imprimeMap();
                    }
                }else if(command.compareTo ("m") == 0){
                    if (command.compareTo ("s") == 0) {

                    } else if ( command . compareTo ("a") == 0) {

                    } else if ( command . compareTo ("w") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.atacarMostro(-1, 0);
                        mapa1.imprimeMap();
                    } else if ( command . compareTo ("d") == 0) {

                    }
                }

                command = keyboard.nextLine ();

            }
            else if(command.compareTo("m") == 0){
                energia = dadoHeroi.rolarDado(2);
                while(energia>0){

                    System.out.printf("Movimentos poss�veis: %d\nA��es dispon�veis: w - cima; a - esquerda; s - baixo; d - direita; p - parar\n", energia);
                    command = keyboard.nextLine ();
                    if (command.compareTo ("s") == 0) {
                        //heroi.moveHeroiVertical(-1);
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(1, 10);
                        mapa1.imprimeMap();
                        energia -= 1;
                    } else if ( command . compareTo ("a") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(0, -1);
                        mapa1.imprimeMap();
                        energia -= 1;
                    } else if ( command . compareTo ("w") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(-1, 0);
                        mapa1.imprimeMap();
                        energia -= 1;
                    } else if ( command . compareTo ("d") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(0, 1);
                        mapa1.imprimeMap();
                        energia -= 1;
                    }

                    else if ( command . compareTo ("p") == 0) {
                        energia = 0;
                    }
                }
                turno +=1;
            }



        }
 
	}
      
}