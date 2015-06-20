import java.util.*;

//Get a date (mon/day/year) from user. Printexact the week of dates (Sun to Sat). ex) input: 2/20/2001 if the day isWednesday
//output: Sunday 2/17/2001
//Monday 2/18/2001
//Tuesday 2/19/2001
//Wednesday 2/20/2001
//Thursday 2/21/2001
//Friday 2/22/2001
//Saturday 2/23/2002

//注意：判断闰年条件①：非整百年数除以4，无余为闰，有余为平；②整百年数除以400，无余为闰有余平
//Assume the input format is correct

public class Calendar {

	public List<String> pathresult = new ArrayList<String>();
	public Map<Integer,String> weekNames = new HashMap<Integer,String>();
	
	int[] days ={31,28,31,30,31,30,31,31,30,31,30,31};
	
	public void test() {
		sol("2/20/2001",3);
	}
	
	public void init(){
		weekNames.put(1, "Monday");
		weekNames.put(2, "Tuesday");
		weekNames.put(3, "Wednesday");
		weekNames.put(4, "Thursday");
		weekNames.put(5, "Friday");
		weekNames.put(6, "Saturday");
		weekNames.put(7, "Sunday");
	}
	
	public boolean isLeap(int year){
		return (year%100 != 0 && year%4 == 0) || (year % 400 == 0);
	}
	
	public int numbersOfDays(int month, int year){
		if(isLeap(year) && month == 2) return 29;
		return days[month-1];
	}
	
	public void sol(String date, int whichDay) {
		this.init();
		String[] thedate = date.split("\\/");
		int month = Integer.valueOf(thedate[0]);
		int day = Integer.valueOf(thedate[1]);
		int year = Integer.valueOf(thedate[2]);
		this.findWeek(day, month, year, whichDay);
	}
	
	public void findWeek(int day, int month, int year, int whichDay){
		int tempday = day;
		int tempmonth = month;
		int tempyear = year;
		int tempwhichday = whichDay;
		
		while(tempwhichday > 1){
			if(tempday == 1){
				if(tempmonth == 1){
					tempyear --;
					tempmonth = 12;
				}else{
					tempmonth--;
				}
				tempday = this.numbersOfDays(tempmonth, tempyear);
			}else{
				tempday--;
			}
			tempwhichday--;
		}
		
		
		for(int i = 1; i <= 7; i++){
			String result = weekNames.get(i) + " " + tempmonth + "/" + tempday + "/" + tempyear;
			System.out.println(result);
			tempday++;
			if(tempday > this.numbersOfDays(tempmonth, tempyear)){
				if(tempmonth == 12){
					tempmonth = 1;
					tempyear++;
				}else{
					tempmonth++;
				}
				tempday = 1;
			}
		}
	}
}