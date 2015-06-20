/*
*	1) Given two words, find if second word is the round rotation of first word.
*	For example: abc, cab
*	return 1
*	since cab is round rotation of abc
*
*	Example2: ab, aa
*	return -1
*	since aa is not round rotation for aa
*/

	public static boolean isRotation (String s1, String s2) {
		int len = s1.length();

		/*Check that s1 and s2 are equal length and not empty*/
		if (len == s2.length() && len > 0) {
			/* concatenate s1 and s1 within new buffer*/
			String s1s1= s1 + s1;
			return s1s1.contains(s2);
		}

		return false;
	}