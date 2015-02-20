//7/10 passed, 3 timed out
public int countUneatenLeaves(int N, int[] A) {
	int uneatenLeaves = 0;
	int ASize = A.length;
	int countEaten = 0;

	HashMap<Integer,Integer> positionEatenHash = new HashMap<Integer,Integer>();
	for( int i = 0; i < ASize; i++ ){
		int catervalue = A[i];
		for(int j = 1; j*catervalue <= N; j++){
			if(!positionEatenHash.containsKey(A[i]*j)){
				positionEatenHash.put(A[i]*j, 1);
				countEaten++;
			}
		}
	}
	uneatenLeaves = N - countEaten;
	return uneatenLeaves;
}

