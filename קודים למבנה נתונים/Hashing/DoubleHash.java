package Hashing;
public class DoubleHash {
	private int[] A;
	private int size=0;
	private double r;
	public DoubleHash(int capacity)
	{
		A = new int[2*capacity];
		for(int i=0;i<A.length;i++)
		{
			A[i] = -1; // -1 means empty
			r = Math.random();
		}
	}
	public boolean add(int key)
	{
		if(size == A.length) return false;
		int counter = 1;
		while(true)
		{
			int h = Hash(key,counter);
			if(A[h] == -1)
			{
				A[h] = key ;
				size ++ ;
				return true;
			}
			else
				counter ++ ; 
		}
	}
	public boolean search( int key )
	{
		int counter = -1;
		while ( counter <= size )
		{
			int h = Hash(key,counter);
			if(A[h] == key ) return true;
			else if ( A[h] == -1 ) return false;
			else counter ++ ;
		}
		return false;
	}
	public int Hash(int x, int times)
	{
		return (int)(x* Math.pow(r, times))%A.length;
	}
}
