public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if(words==null || words.length==0)
            return res;
        int count = 0;
        int last = 0;
        for(int i=0;i<words.length;i++){
            //count是上一次计算的单词的长度，words[i].length()是当前尝试放的一个单词的长度，
            //假设当前放上了这个单词，那么这一行单词跟单词间的间隔数就是i-last
            //判断这些总的长度加起来是不是大于L（超行数了）
            if(count + words[i].length() + (i-last) > L){
                int spaceNum = 0;
                int extraNum = 0;
                //因为尝试的words[i]失败了，所以间隔数减1.此时判断剩余的间隔数是否大于0
                if( i-last-1 >0){
                    //是间隔的倍数（为啥要减1，因为尝试当前words[i]后发现比L长了，
                    //所以当前这个单词不能算作这行，所以间隔就减少一个
                    spaceNum = (L-count)/(i-last-1);
                    extraNum = (L-count)%(i-last-1);//不是倍数的话还要计算
                }
                StringBuilder str = new StringBuilder();
                for(int j=last;j<i;j++){
                    str.append(words[j]);
                    if(j<i-1){//words[i-1]的话后面就不用填空格了，所以这里j<i-1
                        for(int k=0;k<spaceNum;k++)
                            str.append(" ");
                        
                        if(extraNum>0)
                            str.append(" ");
                        
                        extraNum--;
                    }
                }
                
                //下面这个for循环作用于一行只有一个单词还没填满一行的情况
                for(int j=str.length();j<L;j++)
                    str.append(" ");
                    
                res.add(str.toString());
                count=0;
                last=i;//下一个开始的单词
            }
            count += words[i].length();
        }
        
        //处理最后一行
        StringBuilder str = new StringBuilder();
        for(int i=last;i<words.length;i++){
            str.append(words[i]);
            if(str.length()<L)
                str.append(" ");
        }
        for(int i=str.length();i<L;i++)
            str.append(" ");
        
        res.add(str.toString());
        return res;
    }
}