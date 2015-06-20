/*
Implement two functions
	void hit()
	long getHits() //返回五分钟内hit了几次
*/

public class HitsCounter {
    private vector<int> hitcnt; // stores the hit for each second
    private long long total;    // always keeps the current hit count
    private long long last;     // the time of last hit
    private int size;           // size of hitcnt array, for this question set to 300

    public HitsCounter(int secondCnt) {
            // in this case, secondCnt shoule be 300
            hitcnt = vector<int>(secondCnt, 0);
            total = 0;
            size = secondCnt;
        }
        
        long long getHit() {
            // total always stores the current hit count
            return total;
        }
        
        void hit(long long cur) {
            // suppose the unit of time() is second
            // long long cur = time();
            // if cur > last, some previous value need to be reset to 0
            // also, if t - last > size, we've set 0 for entire queue, no need to continue
            for (int t = last + 1; t <= cur && t - last <= size; t++) {
                // update total, and reset the specific count to 0
                total -= hitcnt[t % size];
                hitcnt[t % size] = 0;
            }
            
            // update hitcnt, total and last for this hit
            hitcnt[cur % size]++;
            total++;
            last = cur;
        }
}