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
		int turno = 1, energia, acao, movimento, sucesso ;
		Dado dadoHeroi = new Dado();
		boolean running = true ;
        while ( running ) { 
        	
        	acao = 0; movimento = 0;
        	while (acao != 1 || movimento != 1){  		
        	if(acao == 0 && movimento == 0){
        		System.out.printf("Turno %d\nAções disponíveis: e - interagir; a - atacar; q - usar mágias; i - abrir inventário; m - mover; p - encerrar turno; f - sair do jogo\n", turno);
        	}
        	else if(acao == 1){
        		System.out.printf("Turno %d\nAções disponíveis:i - abrir inventário; m - mover; p - encerrar turno; f - sair do jogo\n", turno);             	
        	}
        	else if(movimento == 1){
        		System.out.printf("Turno %d\nAções disponíveis: e - interagir; a - atacar; q - usar mágias; i - abrir inventário; p - encerrar turno; f - sair do jogo\n", turno);             	
        	}
        	String command = keyboard.nextLine ();
            if (command.compareTo("f") == 0) {
            	System.out.println("Game Over");             	
                running = false ;
            } 
            else if(command.compareTo("m") == 0 && movimento == 1){
            	System.out.println("Só é possível rolar os dados de movimento uma vez por turno.");   
            }
            else if(command.compareTo("m") == 0 && movimento == 0){
            	energia = dadoHeroi.rolarDado(2);
            	while(energia>0){
            		sucesso = 0;
            		System.out.printf("Movimentos possíveis: %d\nAções disponíveis: w - cima; a - esquerda; s - baixo; d - direita; e - abrir porta; p - parar\n", energia);          
                    command = keyboard.nextLine ();
                    if (command.compareTo ("s") == 0) {
                        //heroi.moveHeroiVertical(-1);
                    	mov = new Action(mapa1, hero);
                    	sucesso = mov.moveHeroi(0, 1);                        
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                    } else if ( command . compareTo ("a") == 0) {
                        mov = new Action(mapa1, hero);
                        sucesso = mov.moveHeroi(-1, 0);
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                    } else if ( command . compareTo ("w") == 0) {
                        mov = new Action(mapa1, hero);
                        sucesso = mov.moveHeroi(0, -1);
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                    } else if ( command . compareTo ("d") == 0) {
                        mov = new Action(mapa1, hero);
                        sucesso = mov.moveHeroi(1, 0);
                        mapa1.imprimeMap();
                        if(sucesso == 1) energia -= 1;
                    }
                    else if ( command . compareTo ("p") == 0) {
                        energia = 0;
                    }
            	}   
            	movimento=1;
            }
            else if(command.compareTo ("p") == 0){
            	System.out.println("Turno encerrado"); 
            	turno+=1;
            	acao = 1; movimento = 1;
            }            
            

            }	
    	}        
	}
      
}