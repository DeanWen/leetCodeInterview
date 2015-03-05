import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//We are given a specific time(like 02:23), weneed to get the angle between hour and minute(less than 180)



public class ClockAngle {
	
	public void test(){
		String newString = sol("06:00");
		System.out.println(newString);
	}
	
	public String sol(String time){
		String[] splited = time.split(":");
		int h = Integer.valueOf(splited[0]);
		int min = Integer.valueOf(splited[1]);
		
		double angle = Math.abs(min*6 - (h*(360/12)+min*(30/60)));
		if(angle > 180) angle = 360-angle;
		return angle+"";
	}
	
	
}