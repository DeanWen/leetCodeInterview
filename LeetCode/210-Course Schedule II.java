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