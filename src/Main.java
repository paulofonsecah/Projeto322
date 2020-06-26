import java.util.Scanner;

public class Main {

	Scanner keyboard = new Scanner ( System .in);
	boolean running = true;
    while (running) {
    	//roda o jogo
    	if(hp personagem<= 0) {
    		running = false ;
    	}
    	System.out.print(" Qual a sua ação: 1- atacar, 2- mover ou 3- procurar tesouro em volta ");
    	String command = keyboard . nextLine ();
    	if ( command . compareTo (" 0 ") == 0)
    	running = false ;
    	if ( command . compareTo (" 1 ") == 0)
    		//ataca
    		// cria condição para mago usar magia
    	if ( command . compareTo (" 2 ") == 0)
    		
    	if ( command . compareTo (" 3 ") == 0)
    		//procura tesouro
    		
    		
    		
      if( inimigos == 0) {
    	 running = false ;
      }	 
      
    }
     if(hp>0 && inimigos ==0) {
    
    System.out.print(" Você venceu! : ");
     }
     else(){
    System.out.print(" Você foi derrotado! : ");
     }
     
}
