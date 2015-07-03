public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        double res = myPow(x, n/2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }
}