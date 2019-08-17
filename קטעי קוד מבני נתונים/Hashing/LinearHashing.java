package Hashing;
public class LinearHashing {
	private int A[];
	private int size = 0;
	private double r;
	public LinearHashing(int capacity)
	{
		A = new int[2*capacity];
		for(int i=0; i<A.length;i++)
			A[i] = -1; // means empty
		r = Math.random();
	}
	public boolean add(int key)
	{
		if(size == A.length) return false;
		else
		{
			int h = Hash(key);
			while(true)
			{
				if (A[h] == -1) // found a place
				{
					A[h] = key;
					size ++;
					return true;
				}
				else h = (h+1) % A.length;
			}
		}
	}
	public boolean search(int key )
	{
		int h = Hash(key);
		int counter = 0;
		while (counter < size ) 
		{
			if(A[h] == key ) return true;
			else if(A[h] == -1) return false;
			else
			{
				h = (h+1)%A.length;
				counter ++ ; // exit if search all array
			}
		}
		return false;
	}
	public int Hash(int x)
	{
		// return x % a.length;
		return (int)(x*r)%A.length;
	}
}
