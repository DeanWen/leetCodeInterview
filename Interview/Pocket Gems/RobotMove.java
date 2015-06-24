import java.util.*;

public class RobotMove {
	private final static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) {
				return false;
			}
			
			if (obj == this) {
				return true;
			}
			
			Point p = (Point)obj;
			return p.x == this.x && p.y == this.y;
		}
		
		@Override
		public int hashCode() {
			return 31 * x + y;
		}

	}
	
	public static int countSteps(int k) {
		
		HashSet<Point> hset = new HashSet<>();
		dfs(hset, 0, 0, k);
		
//		int max = 0;
//		for (Point p : hset) {
//			if (p.x == 1) {
//				max = Math.max(max, p.y);
//			}
//		}
//		System.out.println(max);
		return hset.size();
	}

	private static void dfs(HashSet<Point> hset, int x, int y, int k) {
		// TODO Auto-generated method stub
		int len = 0;
		len += countSum(x);
		len += countSum(y);
		if (len > k) {
			return;
		}
		
		hset.add(new Point(x, y));
		
		for (int i = 0; i < dir.length; i++) {
			int xVal = x + dir[i][0];
			int yVal = y + dir[i][1];
			if (!hset.contains(new Point(xVal, yVal))) {
				//hset.add(new Point(xVal, yVal));
				dfs(hset, xVal, yVal, k);
			}
		}
	}

	private static int countSum(int x) {
		int count = 0;
		while (x != 0) {
			count += Math.abs(x % 10);
			x = x / 10;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countSteps(5));

	}
}
