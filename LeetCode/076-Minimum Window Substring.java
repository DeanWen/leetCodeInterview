public class Solution {
    public String minWindow(String S, String T) {
        String res = "";
        if(S == null || T == null || S.length()==0 || T.length()==0)
            return res;
        
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i =0;i < T.length(); i++) {
            if(!dict.containsKey(T.charAt(i))) {
                dict.put(T.charAt(i), 1);
            } else {
                dict.put(T.charAt(i), dict.get(T.charAt(i))+1);
            }
        }
        
        int count = 0;
        int pre = 0;
        int minLen = S.length()+1;
        for(int i = 0; i < S.length(); i++){
            if(dict.containsKey(S.charAt(i))){
                dict.put(S.charAt(i), dict.get(S.charAt(i)) - 1);
                if(dict.get(S.charAt(i)) >= 0) {
                    count++;
                }
                while(count == T.length()){
                    if(dict.containsKey(S.charAt(pre))){
                        dict.put(S.charAt(pre), dict.get(S.charAt(pre)) + 1);
                        
                        if(dict.get(S.charAt(pre)) > 0){
                            if(minLen > i - pre + 1){
                                res = S.substring(pre, i + 1);
                                minLen = i - pre + 1;
                            }
                            count--;
                        }
                    }
                    pre++;
                }
            }//end for if(dict.containsKey(S.charAt(i)))
        }
        
        return res;
    }
}