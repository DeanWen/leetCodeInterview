/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        
        List<Interval> res = new LinkedList<>();
        Collections.sort(intervals, new myComparator());
        
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end >= curr.start) {
                prev.end = Math.max (curr.end, prev.end);
            }else {
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);
        
        return res;
    }
    
    private class myComparator implements Comparator<Interval> {
        @Override
        public int compare (Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}