public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if(strs == null || strs.length ==0) {
            return result;
        }
        
        // process the data
    	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    	for (int i = 0; i < strs.length; i++) {
    		char[] charArray = strs[i].toCharArray();
    		Arrays.sort(charArray);
    		String strKey = new String(charArray);
    		// if not such key, create value list with current str 
    		if (!map.containsKey(strKey)) {
    			ArrayList<String> temp = new ArrayList<String>();
    			temp.add(strs[i]);
    			map.put(strKey, temp);
    		}else { // if contains such key, add as a new item in value list
    			ArrayList<String> temp = map.get(strKey);
    			temp.add(strs[i]);
    			map.put(strKey,temp);
    		}
    	}
    
    	// traversal hashmap re-write the iterator
    	Iterator iter = map.values().iterator();
    	while(iter.hasNext()) {
    		ArrayList<String> item = (ArrayList<String>)iter.next();
    		if (item.size() > 1) {
    			result.addAll(item);
    		}
    	}
    
    	return result;
    }
}