import java.util.*;
public class Solution {
	/*
	 * Complete the functions below.
	 */
	    public static class Student {
	        int id;
	        int capacity;
	        int start;
	        int end;
	        TreeMap<Integer, Class> classes;
	        HashSet<Integer> availableTime;
	        
	        Student(int id, int capacity, int start, int end) {
	            this.id = id;
	            this.capacity = capacity;
	            this.start = start;
	            this.end = end;
	            classes = new TreeMap<Integer, Class>();
	            // To avoid huge time range
	            // This part can be restructured to be
	            // HashSet(store occupied time)
	            if (end - start < 10000) 
	            availableTime = new HashSet<Integer>();
	            for (int i = start; i <= end; i++) {
	                availableTime.add(i);
	            }
	        }
	    }

	    public static class Class {
	        int id;
	        int capacity;
	        int time;
	        TreeMap<Integer, Student> students;
	        
	        Class(int id, int capacity, int time) {
	            this.id = id;
	            this.capacity = capacity;
	            this.time = time;
	            students = new TreeMap<Integer, Student>();
	        }
	    }
	    
	    public static HashMap<Integer, Student> roster = new HashMap<Integer, Student>();
	    public static HashMap<Integer, Class> classList = new HashMap<Integer, Class>();

		public static String addClass(int id, int capacity, int time) {
	  // If the class is added successfully, 
	  // return "Successfully added class ID". 
	  // Otherwise, return "Error adding class ID".
	        if (!classList.containsKey(id)) {
	            Class cls = new Class(id, capacity, time);
	            classList.put(id, cls);
	        }else {
	            return "Error adding class " + id;
	        }
	        
	        return "Successfully added class " + id;
		}
		
		public static String removeClass(int id) {
	  //If the class is removed successfully,
	  // return "Successfully removed class ID". 
	  // Otherwise, return "Error removing class ID".
	        if (classList.containsKey(id)) {
	            Class currClass = classList.get(id);
	            TreeMap<Integer, Student> currEnrolledStu = currClass.students;
	            Iterator<Integer> iter = currEnrolledStu.keySet().iterator();
	            while(iter.hasNext()) {
	                Student eachStu = currEnrolledStu.get(iter.next());
	                if (eachStu.classes.containsKey(id)) {
	                    eachStu.classes.remove(id);
	                }
	            }
	            classList.remove(id);
	        }else {
	            return "Error removing class " + id;
	        }
	        
	        return "Successfully removed class " + id;
		}
		
		public static String infoClass(int id) {
	  // If the class does not exist, 
	  // return "Class ID does not exist". 
	  // If the class is empty, 
	  // return "Class ID is empty". 
	  // Otherwise, return the string 
	  // "Class ID has the following students: LIST" 
	  // where LIST is a sorted, comma-separated list 
	  // of student IDs corresponding to students currently 
	  // in the class.
	        
	        if (!classList.containsKey(id)) {
	            return "Class " + id + " does not exist";
	        }else {
	            if (classList.get(id).students.size() == 0) {
	                return "Class " + id + " is empty";
	            }else {
	                Class curr = classList.get(id);
	                TreeMap<Integer, Student> currEnrolledStu = curr.students;
	                Iterator<Integer> iter = currEnrolledStu.keySet().iterator();
	                StringBuilder sb = new StringBuilder();
	                sb.append("Class " + id + " has the following students: ");
	                while(iter.hasNext()) {
	                    sb.append(iter.next() + ", ");
	                }
	                
	                return sb.toString();
	            }
	        }
		}
		
		public static String addStudent(int id, int capacity, int start, int end) {
	  // If the student is added successfully, 
	  // return "Successfully added student ID". 
	  // Otherwise, return "Error adding student ID".
	        if (!roster.containsKey(id)) {
	            Student stu = new Student(id, capacity, start, end);
	            roster.put(id, stu);
	        }else {
	            return "Error adding student " + id;
	        }
	        return "Successfully added student " + id;
		}
		
		public static String removeStudent(int id) {
	  // If the student is removed successfully, 
	  // return "Successfully removed student ID". 
	  // Otherwise, return "Error removing student ID".
	        if (roster.containsKey(id)) {
	            Student stu = roster.get(id);
				TreeMap<Integer, Class> currRegisterClasses = stu.classes;
				Iterator<Integer> iter = currRegisterClasses.keySet().iterator();
				while (iter.hasNext()) {
					Class eachClass = currRegisterClasses.get(iter.next());
					if (eachClass.students.containsKey(id)) {
						eachClass.students.remove(id);
					}
				}
				roster.remove(id);
	        }else {
	            return "Error removing student " + id;
	        }
	        
	        return "Successfully removed student " + id;
		}
		
		public static String infoStudent(int id) {
	  // If the student does not exist, 
	  // return "Student ID does not exist". 
	  // If the student is not taking any classes, 
	  // return "Student ID is not taking any classes". 
	  // Otherwise, return the string 
	  // "Student ID is taking the following classes: LIST" 
	  // where LIST is a sorted, comma-separated list of class IDs 
	  // corresponding to classes that the student is 
	  // currently taking.
	        if (!roster.containsKey(id)) {
	            return "Student " + id + " does not exist";
	        }else {
	            if (roster.get(id).classes.size() == 0) {
	                return "Student " + id + " is not taking any classes";
	            }else {
	                Student curr = roster.get(id);
	                TreeMap<Integer, Class> currEnrolledCls = curr.classes;
	                Iterator<Integer> iter = currEnrolledCls.keySet().iterator();
	                StringBuilder sb = new StringBuilder();
	                sb.append("Student " + id + " is taking the following classes: ");
	                while(iter.hasNext()) {
	                    sb.append(iter.next() + ", ");
	                }
	                
	                return sb.toString();
	            }
	        }
		}
		
		public static String enrollStudent(int studentId, int classId) {
	  // If enrollment of the student in the class succeeded,
	  // return "Number of free spots left in class CLASSID: FREESPOTS" 
	  // where FREESPOTS is the number of free spots left 
	  // in the class after the student enrolls. 
	  // Otherwise, return "Enrollment of student STUDENTID in class CLASSID failed".
	        Student stu = roster.get(studentId);
	        Class cls = classList.get(classId);
	        
	        if (stu.classes.size() >= stu.capacity) {
	            return "Enrollment of student " + studentId + " in class " + classId + " failed";
			}
			if (cls.students.size() >= cls.capacity) {
	            return "Enrollment of student " + studentId + " in class " + classId + " failed";
			}
	        
	        HashSet<Integer> stuAvailable = stu.availableTime;
			if (stuAvailable.contains(cls.time)) {
				stu.classes.put(classId, cls);
				cls.students.put(studentId, stu);
				stuAvailable.remove(cls.time);
			}else {
	            return "Enrollment of student " + studentId + " in class " + classId + " failed";
	        }
	        int freeSpot = cls.capacity - cls.students.size();
	        return "Number of free spots left in class " + classId + ": " + freeSpot;
		}
		
		public static String unenrollStudent(int studentId, int classId) {
	  // If unenrollment of the student in the class succeeded,
	  // return "Number of free spots left in class CLASSID: FREESPOTS" 
	  // where FREESPOTS is the number of free spots left in the class 
	  // after the student unenrolls. Otherwise, return "Unenrollment 
	  // of student STUDENTID in class CLASSID failed".
	        Class cls = classList.get(classId);
			TreeMap<Integer, Student> currEnrolledStudent = cls.students;
			if (currEnrolledStudent.containsKey(studentId)) {
				Student stu = currEnrolledStudent.get(studentId);
				stu.classes.remove(classId);
				stu.availableTime.add(cls.time);
				cls.students.remove(studentId);
	        }else {
	            return "Unenrollment of student " + studentId + " in class " + classId + " failed";
	        }
	        
	        int freeSpot = cls.capacity - cls.students.size();
	        return "Number of free spots left in class " + classId + ": " + freeSpot;
		}
}
