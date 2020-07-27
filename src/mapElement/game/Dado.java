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
	
	public int rolarDadoMov(int numVezes) {
		int move1 , aleatNum1, aleatNum2;
		aleatNum1 = ThreadLocalRandom.current().nextInt(1, 7);
		aleatNum2 = ThreadLocalRandom.current().nextInt(1, 7);
		move1 = aleatNum1 + aleatNum2; 
		System.out.printf(" resultado dos dados: %d, quantas casas voce deseja mover %n" , move1  );
		Scanner keyboard = new Scanner ( System .in); 
	    int move2 = keyboard.nextInt();
		return move2;			
	
	}
	
	public int rolarDado(int numVezes) {
		int i, aleatNum, n;
		n = numVezes;
		int dadoNum = 0;
		for(i=1;i<=n;i++){
			aleatNum = ThreadLocalRandom.current().nextInt(1, 7);
			System.out.printf("Voc� rolou um dado e obteu %d!\n", aleatNum);
			dadoNum += aleatNum;
//			if(aleatNum == 2 || aleatNum == 3 || aleatNum == 5) dadoNum[i-1] = 0; //0 = caveira
//			else if(aleatNum == 4 || aleatNum == 6) dadoNum[i-1] = 1; //1 = escudo heroi
//			else if(aleatNum == 1) dadoNum[i-1] = 2; //2 = escudo monstro
		}
		System.out.printf("Valor total dos dados: %d\n", dadoNum);
		return dadoNum;
		}

	public ArrayList<Integer>  rolarDadoAttack(int numVezes) {
		int i, aleatNum, n;
		n = numVezes;
		ArrayList<Integer> dados = new ArrayList<Integer>();
		dados.add(0);
		dados.add(0);
		dados.add(0);
		for(i=1;i<=n;i++){
			aleatNum = ThreadLocalRandom.current().nextInt(1, 7);
			System.out.printf("Voc� rolou um dado e obteu %d!\n", aleatNum);
			if(aleatNum==1 || aleatNum==2 || aleatNum==3 ){
				dados.set(0,dados.get(0)+1);
			}else if(aleatNum==4 ||aleatNum==5){
				dados.set(1,dados.get(1)+1);
			}else if(aleatNum==6){
				dados.set(2,dados.get(2)+1);
			}
		}
		return dados;
	}
   
	
	public int getNumFaces() {
		return numFaces;
	}
	
	public void setNumFaces(int numFaces) {
		this.numFaces = numFaces;
	}
	
	
		
		
	
	
	
	
	
	
	
}
