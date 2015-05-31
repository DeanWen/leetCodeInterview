/*
* Use Priority Queue to implement a min Heap
* keep the capacity k
* the top should be kth
*
*   Time Complexity: O(nlogk)
*   Space Complexity: O(k)
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if(minHeap.size() >= k + 1){
                minHeap.poll();
            } 
        }
        
        return minHeap.peek();
    }
}