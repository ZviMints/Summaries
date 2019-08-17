package Hashing;
import java.util.LinkedList;
public class LinkedListHash {
	LinkedList<Integer> A[];
	private double r;
	public LinkedListHash( int capacity )
	{
		A = new LinkedList[capacity];
		for(int i=0; i<A.length;i++)
			A[i] = new LinkedList<Integer>();
		r = Math.random() * A.length;
	}
	public void add(int key)
	{
		int h = Hash(key);
		A[h].add(key);
	}
	public boolean search( int key )
	{
		int h = Hash(key);
		return A[h].contains(key);
	}
	public void remove(int key)
	{
		int h = Hash(key);
		A[h].remove(key);
	}
	public int Hash(int x)
	{
		// return x % a.length;
		return (int)(x * r) % A.length;	
	}
}
