//O(n^3)
//http://www.cnblogs.com/yuzhangcmu/p/4189152.html
public static boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null) {
        return false;
    }
    
    int len = s1.length();
    
    if (s2.length() != len) {
        return false;
    }

    boolean[][][] D = new boolean[len][len][len + 1];
    
    // D[i][j][k] = D[i][]
    for (int k = 1; k <= len; k++) {
        // 注意这里的边界选取。 如果选的不对，就会发生越界的情况.. orz..
        // attention: should use "<="
        for (int i = 0; i <= len - k; i++) {
            for (int j = 0; j <= len - k; j++) {
                if (k == 1) {
                    D[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    continue;
                }
                
                D[i][j][k] = false;
                for (int l = 1; l <= k - 1; l++) {
                    if (D[i][j][l] && D[i + l][j + l][k - l] 
                        || D[i][j + k - l][l] && D[i + l][j][k - l]) {
                        D[i][j][k] = true;
                        break;
                    }
                }
            }
        }
    }
    
    return D[0][0][len];
}


//Recursion
/*
基本的思想就是：在S1上找到一个切割点，左边长度为i, 右边长为len - i。 
有2种情况表明它们是IsScramble
(1). S1的左边和S2的左边是IsScramble， S1的右边和S2的右边是IsScramble
(2). S1的左边和S2的右边是IsScramble， S1的右边和S2的左边是IsScramble 
（实际上是交换了S1的左右子树）
*/
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {  
            return false;  
        }
        if(s1.length() == 1 && s2.length()== 1) {
            return s1.charAt(0) == s2.charAt(0);  
        }
        if(s1.equals(s2)) {
            return true;
        }

        //Dealing With Different Input
        //"abcdefghijklmnopq", 
        //"efghijklmnopqcadb"
        //Scramble must be same
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        String ss1 = new String(t1);
        String ss2 = new String(t2);
        if (!ss1.equals(ss2)) {
            return false;
        }
        

        for(int split = 1; split < s1.length(); split++){
            String s11 = s1.substring(0, split);
            String s12 = s1.substring(split);
           
            String s21 = s2.substring(0, split);
            String s22 = s2.substring(split);
            if(isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }
           
            s21 = s2.substring(0, s2.length() - split);
            s22 = s2.substring(s2.length() - split);
            if(isScramble(s11, s22) && isScramble(s12, s21)) {
                return true;
            }
        }

        return false;
    }
}