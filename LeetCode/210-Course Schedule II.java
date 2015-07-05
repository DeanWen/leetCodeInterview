//DFS Solution
//Time Complexity O(E + V)
//Space Complexity O(E + V)
public class Solution {
    private int index;
    public int[] findOrder(int num, int[][] edges) {
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
        int[] res = new int[num];
        index = res.length - 1;
        for (int i = 0; i < num; i++) {
            if (visited[i] == 0) { //Only Run Unvisited Node
                if (!topsort(visited, map, i, res)) {
                    return new int[0];//if detected a cycle return []
                }
            }
        }
        
        return res;
    }
    /*
    * Using -1, 0, 1 represents 3 states of node
    * inorder to detect cycle
    * 0  : no visit
    * -1 : visiting
    * 1  : complete 
    */
    private boolean topsort (int[] visited, Map<Integer, List<Integer>> map, int it, int[] res) {
        if (visited[it] == -1) return false;
        if (visited[it] == 1) return true;
        
        visited[it] = -1;
        if (map.containsKey(it)) {
            for (Integer neighbor : map.get(it)) {
                if (!topsort(visited, map, neighbor, res)) {
                        return false;
                }
            }
        }
        visited[it] = 1;
        
        res[index--] = it;
        return true;
    }
}


//BFS Solution
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }
     
        int len = prerequisites.length;
     
        //if there is no prerequisites, return a sequence of courses
        if(len == 0){
            int[] res = new int[numCourses];
            for(int m=0; m<numCourses; m++){
                res[m]=m;
            }
            return res;
        }
     
        //records the number of prerequisites each course (0,...,numCourses-1) requires
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }
     
        //stores courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }
     
        int numNoPre = queue.size();
     
        //initialize result
        int[] result = new int[numCourses];
        int j=0;
     
        while(!queue.isEmpty()){
            int c = queue.remove();
            result[j++]=c;
     
            for(int i=0; i<len; i++){
                if(prerequisites[i][1]==c){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }
     
            }
        }
     
        //return result
        if(numNoPre==numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}