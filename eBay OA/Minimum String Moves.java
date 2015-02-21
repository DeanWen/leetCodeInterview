// 1/11 passed
// Totally no idea
public int findMinimumStringMovement() {
    int moves = 0;
    char[] aChar = a.toCharArray();
    char[] bChar = b.toCharArray();
    char cChar;

    if (aChar != bChar) {
        for (int i = 0; i < aChar.length; i++) {
            for (int j = i + 1; j < aChar.length; j++) {
                if (aChar[i] != bChar[i]) {
                    /*
                     * It checks if some character from the array of aChar
                     * is same as other character from the array of B and if
                     * it's j less then the length of the array. If it's
                     * true, then swap the characters and count moves
                     */
                    if (aChar[j] == bChar[i] && j < aChar.length) {
                        for (int k = j; k > i; k--) {
                            cChar = aChar[k];
                            aChar[k] = aChar[k - 1];
                            aChar[k - 1] = cChar;
                            moves++;
                        }
                        /*
                         * In other case, if the last character of array
                         * aChar same as the some character of bChar and
                         * vice versa, then we should check if the i is
                         * equal to 0, in that case we swap 1st and last
                         * character of array and count as 1 move else if i
                         * value is less then the value of length of array
                         * divided with 2 then it swaps that character to
                         * the first one and then swaps with last and counts
                         * the moves.
                         */
                    } else if (aChar[aChar.length - 1] == bChar[i]) {
                        if (i == 0) {
                            cChar = aChar[aChar.length - 1];
                            aChar[aChar.length - 1] = aChar[i];
                            aChar[i] = cChar;
                            moves++;
                        } else if (i < (aChar.length - 1) / 2) {
                            for (int k = i; k > 0; k--) {
                                cChar = aChar[k];
                                aChar[k] = aChar[k - 1];
                                aChar[k - 1] = cChar;
                                moves++;
                            }
                            cChar = aChar[i];
                            aChar[i] = aChar[aChar.length - 1];
                            aChar[aChar.length - 1] = cChar;
                        }
                    } else if (bChar[bChar.length - 1] == aChar[i]) {
                        if (i == 0) {
                            cChar = bChar[bChar.length - 1];
                            bChar[bChar.length - 1] = bChar[i];
                            bChar[i] = cChar;
                            moves++;
                        } else if (i < (aChar.length - 1) / 2) {
                            for (int k = i; k > 0; k--) {
                                cChar = aChar[k];
                                aChar[k] = aChar[k - 1];
                                aChar[k - 1] = cChar;
                                moves++;
                            }
                            cChar = aChar[i];
                            aChar[i] = aChar[aChar.length - 1];
                            aChar[aChar.length - 1] = cChar;
                            moves++;
                        }
                        /*
                         * And the last case is if there is no other option,
                         * then we asks if some characters in array with
                         * positions i and j are different and if the j
                         * value is less then length of the array and do the
                         * swap.
                         */
                    } else {
                        if (aChar[j] != aChar[i] && j < aChar.length) {
                            if (aChar[j] == bChar[j]) {
                                cChar = bChar[j];
                                bChar[j] = bChar[i];
                                bChar[i] = cChar;
                                moves++;
                            }
                            cChar = aChar[j];
                            aChar[j] = aChar[i];
                            aChar[i] = cChar;
                            moves++;
                        } else if (bChar[j] != bChar[i] && j < aChar.length) {
                            if (aChar[j] == bChar[j]
                                    && aChar[j] != aChar[i]) {
                                cChar = aChar[j];
                                aChar[j] = aChar[i];
                                aChar[i] = cChar;
                                moves++;
                            }
                            cChar = bChar[j];
                            bChar[j] = bChar[i];
                            bChar[i] = cChar;
                            moves++;
                        }
                    }
                    /*
                     * At the end, if arrays are equal, then it is done.
                     */
                    if (aChar == bChar) {
                        break;
                    }
                }
            }
        }
    }
    return moves;
}