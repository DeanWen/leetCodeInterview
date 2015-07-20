/*
For example '8192':

1-999 -> countDigitOne(999)

1000-1999 -> 1000 of 1s + countDigitOne(999)

2000-2999 -> countDigitOne(999)

.

.

7000-7999 -> countDigitOne(999)

8000-8192 -> countDigitOne(192)

Count of 1s : countDigitOne(999)*8 + 1000 + countDigitOne(192)

Noticed that, if the target is '1192':

Count of 1s : countDigitOne(999)*1 + (1192 - 1000 + 1) + countDigitOne(192)

(1192 - 1000 + 1) is the 1s in thousands from 1000 to 1192.
*/

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int j = 1;
        int k = n;
        int constant = 0;
        while (k >= 10) {
            k = k /10;
            j = j * 10;
        }
        if (k > 1) {
            constant = j;
        }else {
            constant = n % j + 1;
        }
        
        return constant + k * countDigitOne(j - 1) + countDigitOne(n % j);
    }
}