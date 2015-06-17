public class Solution {
    public static List<String> wordBreak(String s, Set<String> dict) {
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
        for(int i=0; i<s.length(); i++){
            //i是开始位置
            if( dp[i] == null ) continue; //前面的部分必须是可以匹配的
            for(String word:dict){
                int len = word.length();
                int end = i+len;
                if(end > s.length()) continue;
                if(s.substring(i,end).equals(word)){
                    if(dp[end] == null){
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);//记录上一个位置
                }
            }
        }

        List<String> ans = new LinkedList<String>();
        if(dp[s.length()] == null) return ans; 
        ArrayList<String> tmp = new ArrayList<String>();
        dfsStringList(dp,s.length(),ans, tmp);
        return ans;
    }

    public static void dfsStringList(List<String> dp[],int end,List<String> res, ArrayList<String> tmp){
        if(end <= 0){
            String ans = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--)
                ans += (" " + tmp.get(i) );
            res.add(ans);
            return;
        }
        for(String str:dp[end]){
            tmp.add(str);
            dfsStringList(dp,end-str.length(), res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}