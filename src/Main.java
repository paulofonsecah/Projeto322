import java.util.Scanner;
import mapasDefaut.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heroi heroi  = new Heroi(2,2);
		final Map mapa1  =new Map(4,4);
		final Mapa2 mapas = new Mapa2();
		mapas.criarMapa(mapa1);
		mapa1.imprimeMap();
		Scanner keyboard = new Scanner ( System .in);
		boolean running = true ;
        while ( running ) {
        
            System . out. print (" Enter the command : ");
            String command = keyboard . nextLine ();
            if ( command . compareTo (" quit ") == 0) {
                running = false ;
            } else if ( command . compareTo ("s") == 0) {
                heroi.moveHeroiVertical(-1);
                mapa1.imprimeMap();
            } else if ( command . compareTo ("a") == 0) {
                heroi.moveHeroiHorizontal(-1);
                mapa1.imprimeMap();
            } else if ( command . compareTo ("w") == 0) {
                heroi.moveHeroiVertical(1);
                mapa1.imprimeMap();
            } else if ( command . compareTo ("d") == 0) {
                heroi.moveHeroiHorizontal(1);
                mapa1.imprimeMap();
            }
            }	
        
	}
      
}