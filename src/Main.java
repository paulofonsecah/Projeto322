import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map mapa1  =new Map(4,4);
		final Mapa2 mapas = new Mapa2();
		mapa1 = mapas.criarMapa(mapa1);
		Heroi hero = new Heroi(3,3,1,1); //Posição inicial do Heroi: (3,3) na sala (1,1)
		mapa1.map[1][1].room[3][3] = hero;
		mapa1.imprimeMap(); 
		//mapa1.imprimeMap();
		Scanner keyboard = new Scanner ( System .in);
		Action mov;
		int turno = 1;
		Dado dadoHeroi = new Dado();
		int energia;
		boolean running = true ;
        while ( running ) {
        
        	System.out.printf("Turno %d\nAções disponíveis: e - interagir; a - atacar; m - mover; f - sair\n", turno);
            String command = keyboard.nextLine ();
            if ( command . compareTo ("f") == 0) {
                running = false ;
            } 
            else if(command.compareTo("m") == 0){
            	energia = dadoHeroi.rolarDado(2);
            	while(energia>0){
            		
            		System.out.printf("Movimentos possíveis: %d\nAções disponíveis: w - cima; a - esquerda; s - baixo; d - direita; p - parar\n", energia);          
                    command = keyboard.nextLine ();
                    if (command.compareTo ("s") == 0) {
                        //heroi.moveHeroiVertical(-1);
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(0, 1);                        
                        mapa1.imprimeMap();
                        energia -= 1;
                    } else if ( command . compareTo ("a") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(-1, 0);
                        mapa1.imprimeMap();
                        energia -= 1;
                    } else if ( command . compareTo ("w") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(0, -1);
                        mapa1.imprimeMap();
                        energia -= 1;
                    } else if ( command . compareTo ("d") == 0) {
                        mov = new Action(mapa1, hero);
                        mov.moveHeroi(1, 0);
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