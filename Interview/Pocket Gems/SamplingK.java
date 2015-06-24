import java.util.Random;
import java.util.Scanner;

/*
 * random sampling。
 * 有一个infinite的stream，你想sample其中的k个元素。每次
 * 遇到新元素你可以选择加入它，同时放弃原有的一些元素。如何让每个元素被选到的概
 * 率一样，同时不使用多余的空间
 * */
public class SamplingK {
	public int[] sampling (Scanner s, int k) {
		int[] res = new int[k];
		int i = 0;
		while (i < k) {
			res[i++] = s.nextInt();
		}
		
		Random r = new Random();
		while (s.hasNext()) {
			int num = s.nextInt();
			int rand = r.nextInt();
			if (rand < k) {
				res[rand] = num;
			}
		}
		
		return res;
	}
}
