package game;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Dado {

	private int valorPadraoNumFaces = 6;
	private int numFaces;
	
	
	public Dado(int numFaces) {
		this.numFaces = numFaces;
		
	}
	
	public Dado() {
		this.numFaces = valorPadraoNumFaces;
	}
	
	/*
	public int rolarDadoMov(int numVezes) {
		int move1 , aleatNum1, aleatNum2;
		aleatNum1 = ThreadLocalRandom.current().nextInt(1, 7);
		aleatNum2 = ThreadLocalRandom.current().nextInt(1, 7);
		move1 = aleatNum1 + aleatNum2; 
		System.out.printf(" resultado dos dados: %d, quantas casas voce deseja mover %n" , move1  );
		Scanner keyboard = new Scanner ( System .in); 
	    int move2 = keyboard.nextInt();
		return move2;			
	
	}*/
	
	public int rolarDado(int numVezes) {
		int i, aleatNum, n;
		n = numVezes;
		int dadoNum = 0;
		for(i=1;i<=n;i++){
			aleatNum = ThreadLocalRandom.current().nextInt(1, numFaces+1);
			System.out.printf("Voce rolou um dado e obteu %d!\n", aleatNum);
			dadoNum += aleatNum;
//			if(aleatNum == 2 || aleatNum == 3 || aleatNum == 5) dadoNum[i-1] = 0; //0 = caveira
//			else if(aleatNum == 4 || aleatNum == 6) dadoNum[i-1] = 1; //1 = escudo heroi
//			else if(aleatNum == 1) dadoNum[i-1] = 2; //2 = escudo monstro
		}
		System.out.printf("Valor total dos dados: %d\n", dadoNum);
		return dadoNum;
		}

	public int rolarDado() {
		int i, aleatNum, n;
		aleatNum = ThreadLocalRandom.current().nextInt(1, 7);
		return aleatNum;
	}

	public int rolarDadoAttack(int tipoAtk, int numVezesAtk, int numVezesDef) { //tipoAtk = 0 se heroi atacando, 1 se monstro atacando
		int i, aleatNum;
		int dano=0;
		for(i=1;i<=numVezesAtk;i++){
			aleatNum = ThreadLocalRandom.current().nextInt(1, 7);			
			if(aleatNum == 2 || aleatNum == 3 || aleatNum == 5) {//caveira
				dano+=1; 
				System.out.printf("O atacante rolou um dado de caveira!\n");
			}
			if(aleatNum == 4 || aleatNum == 6) {//escudo heroi
				System.out.printf("O atacante rolou um dado de escudo de heroi!\n");
			}
			if(aleatNum == 1) {//escudo monstro
				System.out.printf("O atacante rolou um dado de escudo de monstro!\n");
			}
		}
		for(i=1;i<=numVezesDef;i++){
			aleatNum = ThreadLocalRandom.current().nextInt(1, 7);			
			if(aleatNum == 2 || aleatNum == 3 || aleatNum == 5) {//caveira
				System.out.printf("O defensor rolou um dado de caveira!\n");
			}
			if(aleatNum == 4 || aleatNum == 6) {//escudo heroi
				System.out.printf("O defensor rolou um dado de escudo de heroi!\n");
				if(tipoAtk == 1) {
					dano -= 1;
				}
			}
			if(aleatNum == 1) {//escudo monstro
				System.out.printf("O defensor rolou um dado de escudo de monstro!\n");
				if(tipoAtk == 0) {
					dano -= 1;
				}
			}
		}
		if (dano<0) dano = 0;
		System.out.printf("Dano total recebido pelo defensor: %d\n", dano);
		return dano;
		}
   
	
	public int getNumFaces() {
		return numFaces;
	}
	
	public void setNumFaces(int numFaces) {
		this.numFaces = numFaces;
	}
	
	
		
		
	
	
	
	
	
	
	
}
