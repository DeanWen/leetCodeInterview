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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        
        List<Interval> res = new LinkedList<>();
        for (Interval each : intervals) {
            if (each.end < newInterval.start) {
                res.add(each);
            }else if (each.start > newInterval.end) {
                res.add(newInterval);
                newInterval = each;
            }else if (each.end >= newInterval.start || each.start <= newInterval.end) {
                int start = Math.min(each.start, newInterval.start);
                int end = Math.max(each.end, newInterval.end);
                newInterval = new Interval(start, end);
            }
        }
        
        res.add(newInterval);
        return res;
    }
}