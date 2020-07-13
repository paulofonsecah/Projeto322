import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Monster m = new Monster(1,2);
		final Trap a = new Trap(2,2);
		final Treasures t = new Treasures(1,1);
		final Door d = new Door (0,0);
		
		
		ArrayList<Monster> mA = new ArrayList<Monster>();
		mA.add(m);
		
		ArrayList<Trap> aA = new ArrayList<Trap>();
		aA.add(a);
		
		ArrayList<Treasures> tA = new ArrayList<Treasures>();
		tA.add(t);
		
		ArrayList<Door> dA = new ArrayList<Door>();
		dA.add(d);
		
		final Sala room = new Sala(mA, aA, tA, dA, 3,3, 0, 0);
		room.createRoom();
		ArrayList<Sala> sA = new ArrayList<Sala>();
		sA.add(room);
		final Map map = new Map(1,1, sA);
		
		map.createMap();
		map.imprimeMap();
		//room.imprime();

	}

}
