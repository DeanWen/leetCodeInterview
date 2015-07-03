public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (numRows < 1) {
            return res;
        }
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(1);
            if (i > 0) {
                for (int j = 0; j < res.get(i - 1).size() - 1; j++) {
                    list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
                }
                list.add(1);
            }
            res.add(list);
        }
        
        return res;
    }
}