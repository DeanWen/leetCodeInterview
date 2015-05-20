/*
http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html

首先要理解题意:
"a"对应"a", 这种匹配不解释了
任意字母对应".", 这也是正则常见
0到多个相同字符x,对应"x*", 比起普通正则,这个地方多出来一个前缀x. 
x代表的是 相同的字符中取一个,比如"aaaab"对应是"a*b"
"*"还有一个易于疏忽的地方就是它的"贪婪性"要有一个限度.比如"aaa"对应"a*a",不能一路贪婪到底
而"匹配"这个问题,非常容易转换成"匹配了一部分",整个匹配不匹配,要看"剩下的匹配"情况.

这就很好的把一个大的问题转换成了规模较小的问题:递归
如果pattern是"x*"类型的话,那么pattern每次要两个两个的减少.否则,就是一个一个 的减少. 
无论怎样减少,都要保证pattern有那么多个.比如s.substring(n), 其中n 最大也就是s.length()
*/
public class Solution {
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;

        // length == 1 is the case that is easy to forget.
        // as p is subtracted 2 each time, so if original
        // p is odd, then finally it will face the length 1
        if (p.length() == 1)
            return (s.length() == 1) 
        		&& (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        // next char is not '*': must match current character
        if (p.charAt(1) != '*') {
            if (s.length() == 0)
                return false;
            else
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && isMatch(s.substring(1), p.substring(1));
        }else{
            // next char is *

            //fist check all following characrer in s to match char*
            while (s.length() > 0 
            	&& (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) 
                    return true;
                s = s.substring(1);
            }
            //then elimate the p by 2 characters
            return isMatch(s, p.substring(2));
        }
    }
}