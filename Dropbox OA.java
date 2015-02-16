/**
 * Dian Wen
 * 2/15/2015
 */
import java.util.*;
public class Main {
	public static HashMap<Integer, Student> roster;
	public static HashMap<Integer, Class> classList;
	
	public static class Student {
		int id;
		int capacity;
		int start;
		int end;
		HashMap<Integer, Class> classes;
		HashSet<Integer> available;

		Student(int id, int capacity, int start, int end) {
			this.id = id;
			this.capacity = capacity;
			this.start = start;
			this.end = end;
			classes = new HashMap<Integer, Class>();
			available = new HashSet<Integer>();
			for (int i = start; i <= end; i++) {
				available.add(i);
			}
		}
	}

	public static class Class {
		int id;
		int capacity;
		int time;
		HashMap<Integer, Student> students;

		Class(int id, int capacity, int time){
			this.id = id;
			this.capacity = capacity;
			this.time = time;
			students = new HashMap<Integer, Student>();
		}
	}
	
	
	public static String addClass(int id, int capacity, int time) {
		if (!classList.containsKey(id)) {
			Class cls = new Class(id, capacity, time);
			classList.put(id, cls);
		}else {
			System.out.println("This class ID exists");
		}
		
		return null;
	}

	// Also unenroll all the students taking the class
	public static String removeClass(int id) {
		if (classList.containsKey(id)) {
			Class currClass = classList.get(id);
			HashMap<Integer, Student> currEnrolledStu = currClass.students;
			Iterator<Integer> iter = currEnrolledStu.keySet().iterator();
			while (iter.hasNext()) {
				Student eachStu = currEnrolledStu.get(iter.next());
				if (eachStu.classes.containsKey(id)) {
					eachStu.classes.remove(id);
				}
			}
			classList.remove(id);
		}else {
			System.out.println("Unable to find this class ID");
		}
		
		return null;
	}
	
	// 顺序输出注册这门课的所有学生Id
	public static String infoClass(int id) {
		if (classList.containsKey(id)) {
			Class curr = classList.get(id);
			HashMap<Integer, Student> currEnrolledStu = curr.students;
			Iterator<Integer> iter = currEnrolledStu.keySet().iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next());
			}
		}else {
			System.out.println ("Unable to find this class ID");
		}
		
		return null;
	}
	
	// capacity表示这个学生最多可以上几门课，[start, end]表示这个学生有空的时间区间
	public static String addStudent(int id, int capacity, int start, int end) {
		if (start > end) {
			return ("Invalid Time Slot");
		}
		
		if (!roster.containsKey(id)) {
			Student stu = new Student(id, capacity, start, end);
			roster.put(id, stu);
		}else {
			System.out.println ("This student ID exists");
		}
		
		return null;
	}
	
	// Also unenroll the given student from all the classes he/she has enrolled
	public static String removeStudent(int id) {
		if (roster.containsKey(id)) {
			Student stu = roster.get(id);
			HashMap<Integer, Class> currRegisterClasses = stu.classes;
			Iterator<Integer> iter = currRegisterClasses.keySet().iterator();
			while (iter.hasNext()) {
				Class eachClass = currRegisterClasses.get(iter.next());
				if (eachClass.students.containsKey(id)) {
					eachClass.students.remove(id);
				}
			}
			roster.remove(id);
		}else {
			System.out.println ("This student ID does not exist");
		}
		
		return null;
	}
	
	// Also check if the student is available for the class time
	public static String enrollStudent(int studentId, int classId) {
		Student stu = roster.get(studentId);
		Class cls = classList.get(classId);
		
		if (stu.classes.size() >= stu.capacity) {
			System.out.println( "Reach Student: " + stu.id +" Maximum Capacity");
			return null;
		}
		
		if (cls.students.size() >= cls.capacity) {
			System.out.println( "Reach Class: " + cls.id +" Maximum Capacity");
			return null;
		}
		
		HashSet<Integer> stuAvailable = stu.available;
		if (stuAvailable.contains(cls.time)) {
			stu.classes.put(classId, cls);
			cls.students.put(studentId, stu);
			stuAvailable.remove(cls.time);
		}else {
			System.out.println ("Student: " + stu.id +" is not availble for this class");
		}
		
		return null;
	}
	

	public static String unenrollStudent(int studentId, int classId) {
		Class cls = classList.get(classId);
		HashMap<Integer, Student> currEnrolledStudent = cls.students;
		if (currEnrolledStudent.containsKey(studentId)) {
			Student stu = currEnrolledStudent.get(studentId);
			stu.classes.remove(classId);
			stu.available.add(cls.time);
			cls.students.remove(studentId);
		}else {
			System.out.println ("This student is not in this class");
		}
		
		return null;
	}

	
	//不能有两个相同的classId或两个相同的studentId, 但classId可以等于studentId,
	//函数返回的全是String，如果添加的课程id已存在，或删除的课程id不存在等等则输出错误信息
	public static void main(String[] args) {
		roster = new HashMap<Integer, Student>();
		classList = new HashMap<Integer, Class>();
		
		addClass(1, 2, 3);
		addClass(1, 2, 3);//id exist
		addClass(2, 1, 4);
		addClass(3, 10, 9);
		
		addStudent(1, 3, 1, 5);
		addStudent(1, 1, 1, 5);//id exist
		addStudent(2, 3, 3, 2);//invalid time slot
		addStudent(3, 3, 8, 12);
		addStudent(4, 9, 4, 5);
		addStudent(5, 2, 1, 3);
		addStudent(6, 2, 1, 3);
		
		enrollStudent(1, 1);
		enrollStudent(3, 1);//class time does not fit student
		enrollStudent(1, 2);//student time is not available for this class
		enrollStudent(1, 2);//student time is not available for this class
		enrollStudent(5, 1);
		enrollStudent(6, 1);//reach class maximum
		unenrollStudent(6, 1);//this student is not in this class
		
//		removeStudent(1);
//		removeClass(1);
		
		
		
		print();
		
	}
	
	public static void print() {
		System.out.print("Student :  ");
		for (Student stu : roster.values()) {
			System.out.print(stu.id + " ");
		}
		
		System.out.println();
		
		System.out.print("Classes :  ");
		for (Class cls : classList.values()) {
			System.out.print(cls.id + " ");
		}
		
		System.out.println();
		System.out.print("Classes Infor :  ");
		for (Class cls : classList.values()) {
			System.out.println();
			System.out.print("Student: "+ cls.id + " with student: ");
			infoClass(cls.id);
			System.out.print("\t");
		}
		
		System.out.println();
		System.out.print("Student Infor :  ");
		for (Student stu : roster.values()) {
			System.out.println();
			System.out.print("Student: "+ stu.id + " with class: ");
			for (Class each : stu.classes.values()) {
				System.out.print(each.id + " ");
			}	
		}
		
	}

}
