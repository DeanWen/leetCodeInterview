public boolean strStr(String str1, int s1, int e1, 
				String str2, int s2, int e2) {
	String parent = str1.substring(s1, e1 + 1); //O(n)
	String child = str2.substring(s2, e2 + 1); //O(n)

	int diff = parent.length() - child.length();
	int i, j;

	//Time Complexity : O(n*m)
	for (i = 0; i <= diff; i++) {//O(n-m)	
		for (j = 0; j < child.length(); j++) {//O(m)
			if (parent.charAt(i + j) != child.charAt(j)) {
				break;
			}
		}
		if (j == child.length()) {
			return true;
		}
	}

	return false;
}