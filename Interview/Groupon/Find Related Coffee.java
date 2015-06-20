//given object class
public class Coffee {}
//given function
public double getScore(Coffee A, Coffee B) {}

//helper class to match coffee and similarity score
public class Pair {
    Coffee coffee;
    double score;
    Pair (Coffee c, double s) {
      coffee = c;
      score = s;
    }
}

public List<Coffee> getTopK(List<Coffee> menu, Coffee A, int size) {
    List<Pair> scorelist = new ArrayList<Pair>();
    
    //O(n) to get similarity score
    for (Coffee c : menu) {
      Pair p = new Pair (c, getScore(A, c));
      scorelist.add(p);
    }
  
    final int recommendationSize = size;
    PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(recommendationSize, new myComparator());
    
    //O(nlogk) k = size to get the top k for minHeap
    for (Pair p : scorelist) {
       minHeap.offer(p);
       if (minHeap.size() >= reommendationSize + 1) {
         minHeap.poll();
       }
    }
    
    //O(1) size is constant to add coffee to result list
    List<Coffee> result = new List<Coffee>();
    for (Pair p : minHeap) {
      result.add(p.coffee);
    }
  
    return result;
}

//customized comparator
public class myComparator<Pair> implements Comparator<Pair> {
    @Override
    public int compare (Pair a, Pair b) {
      return a.score - b.score;
    }
}