package pocketGem;
import java.util.*;

/**
 * 
 * @author Chen
 * Max Array
 *Input : An array of n numbers, and a number k.
 *Output : An array of n numbers. From 1point 3acres bbs
 *where output = MAX(input, input[i + 1]...... input[i + k - 1])
 *
 *example：
 *[1, 3, 5, 7, 3, 4, 2, 9],  k = 3
 *[5, 7, 7, 7, 4, 9, 9, 9].
**/

public class MaxArray {
        public static int[] maxArray(int[] arr, int k) {
                int[] result = new int[arr.length];
                MaxQueue maxQueue = new MaxQueue();
                // init
                for(int i = 0; i < k && i < arr.length; i++) {
                        maxQueue.offer(arr[i]);
                }
                //
                result[0] = maxQueue.max();
                for(int i = 1; i < arr.length; i++) {
                        if(i + k - 1 < arr.length) {   
                             maxQueue.offer(arr[i + k - 1]);
                        }
                        result[i] = maxQueue.max();
                        maxQueue.poll();
                }
                return result;
        }
        
        public static void main(String[] args) {
                int[] arr = {1, 3, 5, 7, 3, 4, 2, 9};
                System.out.println(Arrays.toString(maxArray(arr, 3)));
        }
}

class MaxQueue {
        private Queue<Integer> queue = new LinkedList<Integer> ();
        private Stack<Node> stack = new Stack<Node> ();
        
        public void offer(int val) {
                queue.offer(val);
                int max = stack.isEmpty() ? val : Math.max(val, stack.peek().max);
                stack.push(new Node(val, max));
        }
        
        public int poll() {
                int val = queue.poll();
                stack.remove(0);
                return val;
        }
        
        public int peek() {
                return queue.peek();
        }
        
        public int max() {
                return stack.peek().max;
        }
}

class Node {
        public int val;
        public int max;
        
        public Node(int v, int m) {
                this.val = v;
                this.max = m;
        }
}
