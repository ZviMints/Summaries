import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,5,9,11};
		System.out.println(BinarySearchNoRecursive(arr,5));
	}
	////////// RECURSE ///////////
	public static boolean BinarySearch(int[] arr, int key)
	{
		if( key < arr[0] || key > arr[arr.length-1]) return false;
		return BinarySearch(arr,0,arr.length-1,key);
	}
	private static boolean BinarySearch(int[] arr,int start, int end, int key)
	{
		if(start <= end)
		{
			int middle = (end+start)/2;
			if(key == arr[middle]) return true;
			else if(key < arr[middle]) return BinarySearch(arr,start,middle-1,key);
			else
				return BinarySearch(arr,middle+1,end,key);	
		}
		return false;
	}
	////////// NO RECURSIVE //////////

	public static boolean BinarySearchNoRecursive(int[] arr, int key)
	{
		if( key < arr[0] || key > arr[arr.length-1]) return false;
		int start = 0, end = arr.length-1;

		while( start <= end )
		{
			int middle = (start + end) / 2;
			if(arr[middle] == key ) return true;
			else if(arr[middle] < key )
				start = middle + 1;
			else
				end = middle - 1;
		}
		return false;
	}

}

