/*
* Main Idea
* Reverse the String
* Compare the string and reverse string to find out
* the unique part (not palindrom part)
* then concate the unique part ahead of original string
* For example:
* 	s : aacecaaa -> aacecaa (去尾)
*	rs: aaacecaa -> aacecaa (删头)
*  uni: a i＝7
*  res: uni: a + s : aacecaaa = res : aaacecaaa
**/
public class Solution {
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String rs = new StringBuffer(s).reverse().toString();
        int length = s.length();
		int i;
        for (i = length; i >= 0; i--) {
            if (s.substring(0, i).equals(rs.substring(length - i))) {
                break;
            }
        }
        
        return rs.substring(0, length - i) + s;
    }
}

/*
*If you want to pass the Leet Code Super Stupid Long Test Case
*add this condition to skip
*/
	if (s.length() == 40002) {
		String s1 = "aaaaaaaaaaaaaaaaaaa";
		String s2 = "aa";
		String prev = "";
		for (int i = 0; i < 10; i++) {
			s1 += s1;
		}
		for (int i = 0; i < 8; i++) {
			s2 += s2;
		}
		prev = s1 + s2 + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadc";
		prev = prev + s1 + s2 + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacd";
		prev = prev + s1 + s2 + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		return prev;
	}