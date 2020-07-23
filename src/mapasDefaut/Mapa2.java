package mapasDefaut;
import game.*;


import java.util.ArrayList;

public class Mapa2 {
	
	public void criarMapa(Map map) {
		final Monster m = new Monster(2,2);
		final Monster m2 = new Monster(3,2);
		final Monster m3 = new Monster(1,1);
		final Trap a = new Trap(3,3);
		final Trap a2 = new Trap(3,0);
		final Treasures t = new Treasures(0,1);
		final Treasures t2 = new Treasures(1,1);
		final Door d = new Door (2,0);
		final Door d2 = new Door (0,2);
		final Door d3 = new Door (2,4);
		final Door d4 = new Door (4,2);
		
		final Door dc1 = new Door (0,0);
		//final Door dc2 = new Door (0,1);
		
		final Door dc3 = new Door (0,0);
		final Door dc4 = new Door (1,1);
		
		
		final Door dc5 = new Door (0,0);
		final Door dc6 = new Door (0,2);
		final Door dc7 = new Door (0,4);
		
		final Door dc8 = new Door (0,0);
		final Door dc9 = new Door (2,0);
		final Door dc10 = new Door (4,0);
		
		ArrayList<Door> dcorredor1 = new ArrayList<Door>();
		dcorredor1.add(dc5);
		dcorredor1.add(dc6);
		dcorredor1.add(dc7);
		
		ArrayList<Door> dcorredor2 = new ArrayList<Door>();
		dcorredor2.add(dc8);
		dcorredor2.add(dc9);
		dcorredor2.add(dc10);
		
		ArrayList<Door> dcanto1e3 = new ArrayList<Door>();
		dcanto1e3.add(dc1);
		//dcanto1e3.add(dc2);
		
		ArrayList<Door> dcanto2e4 = new ArrayList<Door>();
		dcanto2e4.add(dc1);
		//dcanto2e4.add(dc4);
		
		
		ArrayList<Door> dA = new ArrayList<Door>();
		dA.add(d);
		dA.add(d2);
		dA.add(d3);
		dA.add(d4);
		
		final Sala room = new Sala(dA, 5,5, 1, 1);
		room.setMonstros(m);
		final Sala room2 = new Sala(dA, 5,5, 2, 2);
		room2.setArmadilhas(a);
		final Sala room3 = new Sala(dA, 5,5, 1, 2);
		room3.setMonstros(m2);
		final Sala room4 = new Sala(dA, 5,5, 2, 1);
		room4.setTesouros(t);
		
		final Corredor corredorcanto1 = new Corredor(dcanto1e3, 1,1, 0, 0);
		final Corredor corredorcanto3 = new Corredor(dcanto1e3, 1,1, 3, 3);
		final Corredor corredorcanto2 = new Corredor(dcanto2e4, 1,1, 0, 3);
		final Corredor corredorcanto4 = new Corredor(dcanto2e4, 1,1, 3, 0);
		
		
		//corredorcanto1.addnulo(1, 1);
		//corredorcanto2.addnulo(1, 0);
		//corredorcanto3.addnulo(0, 0);
		//corredorcanto4.addnulo(0, 1);
		
		final Corredor corredor1 = new Corredor(dcorredor1, 1,5, 0, 1);
		final Corredor corredor2 = new Corredor(dcorredor1, 1,5, 0, 2);
		final Corredor corredor3 = new Corredor(dcorredor1, 1,5, 3, 1);
		corredor3.setMonstros(m3);
		final Corredor corredor4 = new Corredor(dcorredor1, 1,5, 3, 2);
		
		final Corredor corredor5 = new Corredor(dcorredor2, 5,1, 1, 0);
		final Corredor corredor6 = new Corredor(dcorredor2, 5,1, 2, 0);
		corredor6.setTesouros(t2);
		final Corredor corredor7 = new Corredor(dcorredor2, 5,1, 1, 3);
		corredor7.setArmadilhas(a2);
		final Corredor corredor8 = new Corredor(dcorredor2, 5,1, 2, 3);
		
		//room.createRoom();
		//ArrayList<Sala> sA = new ArrayList<Sala>();
		//sA.add(room);
		map = new Map(4,4);
		
		map.createRooms(room);
		map.createRooms(room2);
		map.createRooms(room3);
		map.createRooms(room4);
		map.createRooms(corredorcanto1);
		map.createRooms(corredorcanto3);
		map.createRooms(corredorcanto2);
		map.createRooms(corredorcanto4);
		map.createRooms(corredor1);
		map.createRooms(corredor2);
		map.createRooms(corredor3);
		map.createRooms(corredor4);
		map.createRooms(corredor5);
		map.createRooms(corredor6);
		map.createRooms(corredor7);
		map.createRooms(corredor8);
		
		
		map.createMap();
		map.imprimeMap();
		//room.imprime();
	}

}
