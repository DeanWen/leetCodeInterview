/*
* Time Complexity : O(n^2)
* Space Complexity : O(n)
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3) {
            return result;
        }
        
        Arrays.sort(num);//O(nlogn)
        for (int i = 0; i < num.length - 2; i++) {
            /*Skip duplicates*/
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = num.length - 1;
            while(left < right) {
                int sum = num[left] + num[right] + num[i];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    result.add(temp);
                    left++;
                    right--;
                    /*Skip duplicates*/
                    while(left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                    while(left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        
        return result;
    }
}