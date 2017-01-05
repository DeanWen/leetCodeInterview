//7/10 passed, 3 timed out
public int countUneatenLeaves(int n, int[] a) {
	BitSet leaves = new BitSet(n);
	for (int j = 0; j < a.length; j++) {
		if(leaves.get(a[j])) continue;
        for (int i = a[j]; i <= n; i = i + a[j]) {
        	leaves.set(i);
		}
	}
	return n - leaves.cardinality();
}

