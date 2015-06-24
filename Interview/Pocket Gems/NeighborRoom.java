/*
 * Version 1
 * Given a list of rooms,
 * and the x coordinate, the y coordinate, the length, the width of each room,
 * tell whether all the rooms are connected.
 *
 * Version 2
 * Neighboring classroom, given a map of m * m, and n classrooms, 
 * determine if every classroom belongs to one single component;
 * bounds: 
 * (1) classroom is at most 3 * 3 in area 
 * (2) no overlapping classrooms 
 * (3) classrooms are at least 5% of m * m in total area 
 * (4) isConnected returns true only when two classroom shares a common edge
 * 
 * 提示：
 * 因为non overlap,直接在一个matrix 里把所有room所占的坐标涂满, 
 * 然后随便找一个顶点bfs看是不是经过的点的数量等于总面积就好了.
 * */

import java.util.*;
public class NeighborRoom {
	private static class Room {
		private int x;
		private int y;
		private int length;
		private int width;

		public Room (int x, int y, int length, int width) {
			this.x = x;
			this.y = y;
			this.length = length;
			this.width = width;
		}
	}

	private static class Node {
		@SuppressWarnings("unused")
		private Room room;
		private List<Node> neighbors;
		public Node(Room room) {
			this.room = room;
			neighbors = new ArrayList<Node>();
		}
	}

	private static boolean checkConnection(Room r1, Room r2) {
		return  !(r1.x + r1.length < r2.x) && 
				!(r2.x + r2.length < r1.x) && 
				!(r1.y + r1.width < r2.y) &&
				!(r2.y + r2.width < r1.y);
	}

	public static boolean check(List<Room> rooms) {
		if (rooms == null || rooms.size() == 0) {
			return true;
		}
		
		//convert to nodes
		List<Node> nodes = new ArrayList<Node>();
		for (Room r : rooms) {
			Node node = new Node(r);
			nodes.add(node);
		}
		
		//add neighbors
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = i + 1; j < nodes.size(); j++) {
				if (checkConnection(rooms.get(i), rooms.get(j))) {
					nodes.get(i).neighbors.add(nodes.get(j));
					nodes.get(j).neighbors.add(nodes.get(i));
				}
			}
		}

		Set<Node> set = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		set.add(nodes.get(0));
		queue.add(nodes.get(0));
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			for (Node n : curr.neighbors) {
				if (!set.contains(n)) {
					set.add(n);
					queue.add(n);
				}
			}
		}
		return rooms.size() == set.size();
	}

	public static void main(String[] args) {
		//test empty
		System.out.println(check(new ArrayList<Room>()));

		//one room
		Room r0 = new Room(0, 0, 1, 1);
		List<Room> l0 = new ArrayList<Room>();
		l0.add(r0);
		System.out.println(check(l0));

		//test all connected
		List<Room> l1 = new ArrayList<Room>();
		Room r1 = new Room(1, 1, 3, 2);
		Room r2 = new Room(2, -2, 3, 3);
		Room r3 = new Room(-1, -2, 3, 1);
		l1.add(r0);
		l1.add(r1);
		l1.add(r2);
		l1.add(r3);
		System.out.println(check(l1));

		//test one disconnected
		List<Room> l2 = new ArrayList<Room>();
		Room r4 = new Room(-1, 2, 1, 1);
		l2.add(r0);
		l2.add(r1);
		l2.add(r2);
		l2.add(r3);
		l2.add(r4);
		System.out.println(check(l2));
	}
}