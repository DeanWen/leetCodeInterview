/*
Using HashMap store the mapping relations
for example :
egg -> add
charAt(1): g->d
charAt(2): g->d

Time Complexity: O(n);
Space Complexity: O(n);
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return true;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)) {
                /*check current position if a mapping b*/
                 if(map.get(a).equals(b)) {
                    continue;
                 } else {
                    return false;
                 }
            }else{
                /*Current position not exist a but exist b => false*/
                if(!map.containsValue(b)) {
                    map.put(a,b);
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}