
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
		if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+y][hero.getX()+x] instanceof Monster) {
        	System.out.print("Não é possivel se mover nesta direção. Motivo: há um monstro nela  \n");
        	return 0;
        }
        else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+y][hero.getX()+x] instanceof Door){
             System.out.printf("Deseja acessar a porta? Pressione 'e' \n");	
             return 0;
            }
        else if(mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()+y][hero.getX()+x] instanceof Treasures){
            System.out.printf("Não é possivel se mover nesta direção. Motivo: há um tesouro nela  \n");	
            return 0;
           }
        else if(hero.getY()+y >=4 || hero.getX()+x >=4 || hero.getY()+y <=0 || hero.getX()+x <=0 ){
        	System.out.printf("Não é possivel se mover nessa direção. Motivo: parede \n");
        	return 0;
        }
	    else{
		    mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = new Empty(0,0);
	        hero.setX(hero.getX()+x); 
	        hero.setY(hero.getY()+y); 
	        mapa.map[hero.getSalaY()][hero.getSalaX()].room[hero.getY()][hero.getX()] = hero;
	        return 1;
	 }
}
	
	
	/*
	public int heal(){
		if (hero.name != "Elfo"){
			System.out.println("Sua classe não possui essa magia!");
			return 0;
		}
		else{
			Dado dice = new Dado(6);
			int cura;
			cura = dice.rolarDado(1);
			hero.setBody(hero.getBody + cura);
			System.out.printf("Você se curou em %d!\n", cura);
			return 1; 		
		}
	}
	
	public int magicMissile(){
		if (hero.name != "Feiticeiro"){
			System.out.println("Sua classe não possui essa magia!");
			return 0;
		}
		else if(monster.name == "Null"){
			System.out.println("Nenhum monstro próximo!");
			return 0;
		}
		else {
			monster.setBody(monster.getBody - 6);
			System.out.println("Você disparou 3 misseis mágicos no alvo, causando 2 de dano cada!");
			return 1; 
		}
		
	}
	*/
	
	
	
	
}
