
import java.util.Arrays;
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		QuickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void QuickSort(int[] arr)
	{
		QuickSort(arr,0,arr.length-1);
	}
	private static void QuickSort(int[] arr,int start, int end)
	{
		if(start < end)
		{
			int pivot = Partition(arr,start,end);
			QuickSort(arr,start,pivot-1);
			QuickSort(arr,pivot+1,end);
		}
	}
	private static int Partition(int[] arr,int start, int end)
	{
		int H = end;
		if(arr.length > 1)
		{
			int L = start + 1;
			int pivot = start;
			swap(arr,pivot,pivot + (int)Math.random()*(end-start));
			
			while(L<=H)
			{
				if(arr[L] < arr[pivot]) L++;
				else if(arr[H] >= arr[pivot]) H--;
				else
					swap(arr,L,H);
			}
			swap(arr,pivot,H);

		}
		return H;
	}
	private static void swap(int[] arr,int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
