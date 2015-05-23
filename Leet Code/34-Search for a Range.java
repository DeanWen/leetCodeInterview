/*
二分查找时特殊处理target = A[mid]的情况
对搜索left：如果target = A[mid]则继续向左找，否则向右找。直到搜索结束，left = start
对搜索right：如果target = A[mid]则继续向右找，否则向左找。直到搜索结束，right = end
最后判断如果A[left], A[right] != target，则表明target不存在于数组中, left = right = -1

http://bangbingsyb.blogspot.com/2014/11/leetcode-search-for-range.html
*/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] bound = new int[2];
        bound[0] = findLeftBound(A, target);
        bound[1] = findRightBound(A, target);
        return bound;
    }
    
    private int findLeftBound (int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
        	int mid = start + (end - start) / 2;
        	if (A[mid] == target) {
        		end = mid - 1; 
        	}else if (A[mid] < target) {
        		start = mid + 1;
        	}else {
        		end = mid - 1;
        	}
        }
        
        if (start >= 0 && start < A.length && A[start] == target) {
            return start;
        }else {
            return -1;
        }
    }
    
    private int findRightBound (int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
        	int mid = start + (end - start) / 2;
        	if (A[mid] == target) {
        		start = mid + 1; 
        	}else if (A[mid] < target) {
        		start = mid + 1;
        	}else {
        		end = mid - 1;
        	}
        }
        
        if (end >= 0 && end < A.length && A[end] == target) {
            return end;
        }else {
            return -1;
        }
    }
}