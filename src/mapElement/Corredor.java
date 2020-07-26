package mapElement;
import java.util.ArrayList;

import mapElement.monstros.Monster;


public class Corredor extends Sala{
	
	public Corredor (ArrayList<Door> p, int tx, int ty, int px, int py) {
		super(p, tx, ty, px, py);
	}
	
	public void imprime(int k, boolean s,Sala sala) {
		for (int j = 0; j < super.getY(); j++){
			if(k<super.getX()) {
				if(super.getRoom()[k][j] instanceof Empty) {
					if (s) {
						System.out.print("V͟");
					}else {
						System.out.print("V");
					}
				}else if(super.getRoom()[k][j] instanceof Monster) {
					if (s) {
						System.out.print("M͟");
					}else {
						System.out.print("M");
					}
				}else if(super.getRoom()[k][j] instanceof Trap) {
					if (s) {
						System.out.print("A͟");
					}else {
						System.out.print("A");
					}
				}else if(super.getRoom()[k][j] instanceof Treasures) {
					if (s) {
						System.out.print("T͟");
					}else {
						System.out.print("T");
					}
				}else if(super.getRoom()[k][j] instanceof Door) {
					if (s && sala!=null && !(sala.getRoom()[0][j] instanceof Door)) {
						System.out.print("V͟");
					}else {
						System.out.print("V");
					}
				}else if(super.getRoom()[k][j] instanceof Nulo) {
					System.out.print("X");
				}	
			}else {
				System.out.print("X");
			}
			
		}
	}

}
