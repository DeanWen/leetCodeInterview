/*
* Example
* A [1, 3] [4, 9] [10, 50]
* B [0, 2] [3, 7] [8, 12]
* return
*   [1, 2] [4, 7] [8, 9] [10, 12]
*
* A［1，5］［10，15］
* B [3,12]
* return 
*   [3,5],[10,12]
*
* Corner Case: B include A (same to A include B)
* A [10-20] [25-40]
* B [5-50]  
* result: 
*   [10-20] [25-40]
* 
*/

/*
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/*
* Optimized Solution using Interval Tree, it like AVL tree, self balancing, which can be 
* done in O (log N)
*/
public static ArrayList<Interval> getOverlap(ArrayList<Interval> l1, ArrayList<Interval> l2) {
    if (l1 == null || l1.size() <= 0) return null;
    if (l2 == null || l2.size() <= 0) return null;
    
    //Merge into one list and sort them
    //O (NlogN)
    ArrayList<Interval> intervals = new ArrayList<Interval>(l1);
    intervals.addAll(l2);
    Collections.sort(intervals, new IntervalComparator()); 
    
    //Travese the whole list to find overlap intervals
    ArrayList<Interval> result = new ArrayList<Interval>();
    Interval prev = intervals.get(0);
    int maxEnd = prev.end;//record the max end point
    for (int i = 1; i < intervals.size(); i++) {
        Interval curt = intervals.get(i);
        //corner case: Interval a inlucde all other intervals
        //for example B include all A, should return all elements in A
        //just need to check the last element in A with the max end point
        if (i == intervals.size() - 1 && curt.end < maxEnd) {
            result.add(curt);
        }
        
        //if current.start < prev.end indicate that there is an overlap
        if (curt.start < prev.end ){
            Interval overlap = new Interval(Math.max(prev.start, curt.start), Math.min(prev.end, curt.end));
            result.add(overlap);
        }
        
        prev = curt; 
        //always keep update the max value;
        maxEnd = maxEnd > prev.end ? maxEnd : prev.end;
    }

    return result;
}

private static class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}



