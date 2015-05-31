/**
 * Add Two numbers Method 1
 * 进入循环，只要L1或L2不为null或carry不为0，
 * 构建新node加入dummy链表尾部，更新carry。
 * Key(在循环内部分类讨论)
 * 细节和陷阱： 
 *      1）在proceed(l = l.next)之前要先判断是否为空 （陷阱）
 *      2）结尾处如果carry还有值，要新建一个节点并连接到链表尾部。
 *      3）用了dummy头节点。
 * Overall Time Complexity is O(N)
 * Overall Space Complexity is O(N)
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
            
        ListNode result = new ListNode(0);
        ListNode dummyNode = result;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            result.next = new ListNode(sum%10);
            carry = sum / 10;
            result = result.next;
        }   

        return dummyNode.next;
    }
}

/**
 * Add Two numbers Method 2
 * Case 1  l1 != null && l2 != null
 * Case 2  l1 != null
 * Case 3  l2 != null 
 * Remember to take care of the last carry-on
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) 
            return null;
            
        ListNode result = new ListNode(0);
        ListNode dummyNode = result;
        int carry = 0;
        
        //case 1
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                result.next = new ListNode(sum - 10);
                carry = 1;
            }else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        
        //case 2
        while (l1 != null) {
            int sum = l1.val + carry;
            if (sum >= 10) {
                result.next = new ListNode(sum - 10);
                carry = 1;
            }else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            
            l1 = l1.next;
            result = result.next;
        }
        
        //case 3
        while (l2 != null) {
            int sum = l2.val + carry;
            if (sum >= 10) {
                result.next = new ListNode(sum - 10);
                carry = 1;
            }else {
                result.next = new ListNode(sum);
                carry = 0;
            }
            
            l2 = l2.next;
            result = result.next;
        }
        
        //last carry on
        if (carry == 1) {
            result.next = new ListNode(carry);
        }
        
        return dummyNode.next;
    }
}

