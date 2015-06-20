//all passed

public static void main(String[] args) {
	int start, end, s, e, flag = 0;
	Scanner scan = new Scanner(System.in);
	Hashtable<Integer, String[]> inputTable = new Hashtable<Integer, String[]>();
	int num = Integer.valueOf(scan.nextLine());

	while(flag < num){
		String[] input = scan.nextLine().split("\\s+");
		inputTable.put(flag, input);
		flag++;
	}

	flag = 0;
	
	while(flag < num){
		String[] range = inputTable.get(flag);
		start = Integer.valueOf(range[0]);
		end = Integer.valueOf(range[1]);
		s = (int)Math.ceil(Math.sqrt(start));
		e = (int)Math.floor(Math.sqrt(end));
		if(e - s >= 0)
			System.out.println(e - s + 1);
		else
			System.out.println(0);
		flag++;
		
	}
}