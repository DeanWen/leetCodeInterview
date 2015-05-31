/**
 * Add Binary Method 1
 * Case 1  l1 != null && l2 != null
 * Case 2  l1 != null
 * Case 3  l2 != null 
 * Remember to take care of the last carry-on
 */

public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int pa = a.length()-1;
        int pb = b.length()-1;
        int carries = 0;
        String rst = "";
        
        while(pb >= 0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
            pb --;
        }
        
        while(pa >= 0){
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }       
        
        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }
}

/**
 * Add Binary
 * 进入循环，只要L1或L2不为null或carry不为0，有效包含最高位进位问题
 * 构建新node加入dummy链表尾部，更新carry。
 * Key(在循环内部分类讨论)
 * 计算char的时候 记住 用ASCII, 和'0'比较
 * String.valueOf() 可以从 ASCII 转化为 String
 * Overall Time Complexity is O(N)
 * Overall Space Complexity is O(N)
 */

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return null;
        }
        
        int la = a.length()-1;//keep index from 0 to length -1
        int lb = b.length()-1;//same above
        String result = "";
        int carry = 0;
        
        while (carry != 0 || la >= 0 || lb >= 0) {
            int sum = carry;
            //keep the every carry on, if the highest carry,
            //will skip blow two ifs, and insert to string. 
            if (la >= 0) {
                sum += (int) (a.charAt(la--) - '0');
            }
            
            if (lb >= 0) {
                sum += (int) (b.charAt(lb--) - '0');
            }
            
            carry = sum / 2;
            result = String.valueOf(sum % 2) + result;
        }
        
        return result;
    }
}