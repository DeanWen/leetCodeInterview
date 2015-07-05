/*
* Time Complexity O(n^2)
* Time Complexity O(n)
*/
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        int globalMax = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Float, Integer> map = new HashMap<Float, Integer>();
            int localMax = 1;
            int duplicate = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                    continue;
                }
                
                float slope = (float)(points[j].y - points[i].y) / (points[j].x - points[i].x);
                if (!map.containsKey(slope)) {
                    map.put(slope, 2);
                }else {
                    map.put(slope, map.get(slope) + 1);
                }
            }
            for (Integer val : map.values()) {
                localMax = Math.max(localMax, val);   
            }
            globalMax = Math.max(duplicate + localMax, globalMax);
        }
        
        return globalMax;
    }
}