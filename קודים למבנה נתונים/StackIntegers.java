public class StackIntegers {
	int[] arr;
	int size=0;

	public StackIntegers(int capacity)
	{
		arr = new int[capacity];
	}

	public boolean push(int key) // לדחוף למחסנית
	{
		if(size == arr.length) return false;
		arr[size++] = key;
		return true;
	}
	public int pop() // להוציא מהמחסנית
	{
		int result = Integer.MAX_VALUE;
		if(size > 0 ) result = arr[--size];
		return result;
	}
	public int top()
	{
		int result = Integer.MAX_VALUE;
		if(size > 0 ) result = arr[size];
		return result;
	}
	public void clear()
	{
		size = 0;
	}
	public boolean empty()
	{
		return (size==0);
	}
	public int size() 
	{
		return size;
	}
	public String toString()
	{
		String result = "" ;
		for(int i=0 ; i<size; i++)
			result = result + arr[i] + ", ";
		return result;
	}

}
