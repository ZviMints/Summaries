
public class Queue<T> {
	T[] a;
	int h=0, size=0;
	
	public Queue(int capacity) {
		a = (T[]) new Object[capacity];
	}
	
	public boolean add(T data) {
		if(size==a.length) return false;
		a[(h+size)%a.length] = data;
		size++;
		return true;
	}
	
	public T remove() {
		if(size==0) return null;
		T answer = (T)a[h];
		size--;
		h = (h+1)%a.length;
		return answer;
	}
	
	public boolean search(T data) {
		for(int i=0; i<size; i++) 
			if(a[(h+i)%a.length].equals(data))
				return true;
		return false;
	}
	
	public int size() { return size; }
	public int capacity() { return a.length; }
	public boolean isEmpty() { return size==0; }
	public void clear() { size=0; }
}

