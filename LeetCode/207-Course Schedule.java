//DFS 
public class Solution {
    public static boolean canFinish(int num, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] pair : edges) {
            if (!map.containsKey(pair[1])) {
                List<Integer> list = new LinkedList<>();
                list.add(pair[0]);
                map.put(pair[1], list);
            }else {
                map.get(pair[1]).add(pair[0]);
            }
        }
        
        int[] visited = new int[num];
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (!topsort(visited, map, i)){
                return false;
            }
        }

        return true;
    }
    
    private static boolean topsort (int[] visited, Map<Integer, List<Integer>> map, int it) {
        if (visited[it] == -1) return false;
        if (visited[it] == 1) return true;
        
        visited[it] = -1;
        if (map.containsKey(it)) {
            for (Integer neighbor : map.get(it)) {
                if (!topsort(visited, map, neighbor)) {
                        return false;
                }
            }
        }
        visited[it] = 1;
        
        return true;
    }
}


//BFS

public boolean canFinish(int numCourses, int[][] prerequisites) {
    if(prerequisites == null){
        throw new IllegalArgumentException("illegal prerequisites array");
    }
 
    int len = prerequisites.length;
 
    if(numCourses == 0 || len == 0){
        return true;
    }
 
    // counter for number of prerequisites
    int[] pCounter = new int[numCourses];
    for(int i=0; i<len; i++){
        pCounter[prerequisites[i][0]]++;
    }
 
    //store courses that have no prerequisites
    LinkedList<Integer> queue = new LinkedList<Integer>();
    for(int i=0; i<numCourses; i++){
        if(pCounter[i]==0){
            queue.add(i);
        }
    }
 
    // number of courses that have no prerequisites
    int numNoPre = queue.size();
 
    while(!queue.isEmpty()){
        int top = queue.remove();
        for(int i=0; i<len; i++){
            // if a course's prerequisite can be satisfied by a course in queue
            if(prerequisites[i][1]==top){
                pCounter[prerequisites[i][0]]--;
                if(pCounter[prerequisites[i][0]]==0){
                    numNoPre++;
                    queue.add(prerequisites[i][0]);
                }
            }
        }
    }
 
    return numNoPre == numCourses;
}