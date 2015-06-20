/*
第二题写一个array 的iterator，但是只需要implement next()这个method，
然后返回是array中是偶数的就行，这个也比较staightforward吧，其实我还是traverse下，每个check就好了。
*/

public class ArrayIterator<Integer> implements Iterator<Integer> {
	private Integer[] array;
	private int pos = 0;

	public ArrayIterator(Integer[] anArray) {
		array = anArray;
	}

	public boolean hasNext() {
		return pos < array.length;
	}

	public Integer next() {
		if (hasNext()) {
			while (array[pos] % 2 != 0) {
				pos++;
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
			}
			return array[pos++];
		}else {
		  	throw new NoSuchElementException();
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}