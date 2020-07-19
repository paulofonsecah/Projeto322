import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Monster m = new Monster(2,2);
		final Monster m2 = new Monster(3,2);
		final Monster m3 = new Monster(1,2);
		final Trap a = new Trap(3,3);
		final Trap a2 = new Trap(2,3);
		final Treasures t = new Treasures(0,1);
		final Treasures t2 = new Treasures(1,1);
		final Door d = new Door (2,0);
		final Door d2 = new Door (0,2);
		final Door d3 = new Door (2,4);
		final Door d4 = new Door (4,2);
		
		//ArrayLists com todos os monstros existentes
		ArrayList<Monster> mA = new ArrayList<Monster>();
		mA.add(m);
		mA.add(m2);
		mA.add(m3);
		
		//ArrayLists com todos os armadilhas existentes
		ArrayList<Trap> aA = new ArrayList<Trap>();
		aA.add(a);
		aA.add(a2);
		
		
		//ArrayLists com todos os tesouros existentes
		ArrayList<Treasures> tA = new ArrayList<Treasures>();
		tA.add(t);
		tA.add(t2);
		
		ArrayList<Door> dA = new ArrayList<Door>();
		dA.add(d);
		dA.add(d2);
		dA.add(d3);
		dA.add(d4);
		
		final Sala room = new Sala(dA, 5,5, 0, 0);
		final Sala room2 = new Sala(dA, 5,5, 1, 0);
		final Sala room3 = new Sala(dA, 5,5, 0, 1);
		final Sala room4 = new Sala(dA, 5,5, 1, 1);
		//room.createRoom();
		//ArrayList<Sala> sA = new ArrayList<Sala>();
		//sA.add(room);
		final Map map = new Map(2,2);
		
		map.createRooms(room);
		map.createRooms(room2);
		map.createRooms(room3);
		map.createRooms(room4);
		
		map.randomMap(mA, aA, tA);
		
		
		map.createMap();
		map.imprimeMap();
		//room.imprime();

	}

}
