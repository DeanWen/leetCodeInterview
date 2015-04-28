//fibnocci array

public class fibnocci {
	public static long fibnocci1(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		return fibnocci1(n-1) + fibnocci1(n-2);
	}

	public static long fibnocci2(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		long num1 = 1;
		long num2 = 1;
		long temp = 0;

		for (int i = 2; i < n; i++) {
			temp = num2;
			num2 = num1 + num2;
			num1 = temp;
		}
		return num2;
	}
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++) {
            System.out.println(i + ": " + fibnocci1(i));
            System.out.println(i + ": " + fibnocci2(i));
        
        }
    }
}