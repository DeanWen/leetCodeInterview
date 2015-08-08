public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0)
            return 0;  
          
        int[] leftnums = new int[ratings.length];  
        int[] rightnums = new int[ratings.length];
        
        leftnums[0] = 1;  
        for(int i = 1;i < ratings.length; i++){  
            if (ratings[i] > ratings[i - 1]) {
                leftnums[i] = leftnums[i - 1] + 1;  
            } else {
                leftnums[i] = 1;  
            }
        }
        
        rightnums[ratings.length - 1] = leftnums[ratings.length - 1];  
        for(int i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]) {
                rightnums[i] = rightnums[i + 1] + 1;
            } else {
                rightnums[i] = 1;
            }
        }
        
        int res = 0;
        for(int i = 0; i < ratings.length; i++) {
            res += Math.max(leftnums[i], rightnums[i]);
        }
        
        return res;
    }
}