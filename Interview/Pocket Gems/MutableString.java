import java.util.Arrays;

/*
 * Round 4
 * design a string class , with implementation of charAt() and substring(b,e), 
 * which substring() requires O(1) time and O(1) space complexity
 * Follow Up:
 * a new method setCharat(index, char) is added, 
 * a substring must keep the changes of parent string that are made before its creation, 
 * but both the parent string and the substring will not affect each other after the creation of the substring, 
 * requires O(1) space complexity. 
 * */
public class MutableString {
	int count;
	char[] value;
	int offset;
	MutableString() {
		this.offset = 0;
		this.count = 0;
		this.value = new char[0];
	}
	MutableString (int begin, int end, char[] origin) {
		if (begin < 0 || end > count || begin > end) {
			throw new StringIndexOutOfBoundsException();
		}
		this.offset = begin;
		this.count = end;
		this.value = Arrays.copyOfRange(origin, this.offset, this.count);
	}
	//Time Complexity O(1)
	//Space Complexity O(1)
	public char charAt(int index) {
		if (index < 0 || index > count) {
			throw new StringIndexOutOfBoundsException();
		}
		return value[index + offset];
	}
	
	//Time Complexity O(1)
	//Space Complexity O(1)
	public MutableString substring(int begin, int end) {
		if (begin < 0 || end > count || begin > end) {
			throw new StringIndexOutOfBoundsException();
		}
		if (begin == 0 && end == count) {
			return this;
		}
		return new MutableString(offset + begin, end - begin, value);
	}
	
	//Time Complexity O(1)
	//Space Complexity O(1)
	public void setcharAt(int index, char c) {
		if (index < 0 || index > count) {
			throw new StringIndexOutOfBoundsException();
		}
		value[offset + index] = c;
	}
}
