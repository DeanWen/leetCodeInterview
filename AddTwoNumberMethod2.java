/**
 * Add Two numbers Method 2
 * 进入循环，只要L1或L2不为null或carry不为0，
 * 构建新node加入dummy链表尾部，更新carry。
 * Key(在循环内部分类讨论)
 *细节和陷阱： 
 *1）在proceed(l = l.next)之前要先判断是否为空 （陷阱）
 *2）结尾处如果carry还有值，要新建一个节点并连接到链表尾部。- Q! X  l3 R' T$ [$ k3 G! E$ _
 *3）用了dummy头节点。
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