import java.util.Arrays;
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		Merge_Sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void Merge_Sort(int[] arr)
	{
		Merge_Sort(arr,0,arr.length-1);	

	}
	private static void Merge_Sort(int[] arr,int start,int end)
	{

		if(start < end)
		{
			int middle = (start + end)/2;
			Merge_Sort(arr,start,middle);
			Merge_Sort(arr,middle+1,end);
			Merge(arr,start,middle,end);
		}
	}

	public static void Merge(int[] arr, int start, int middle, int end)
	{
		int[] temp = new int[ end - start + 1];

		int i=start;
		int j=middle+1;
		int k=0;

		while (i<=middle && j<=end)
		{
			if(arr[i] < arr[j])
			{
				temp[k++]=arr[i++];
			}
			else
				temp[k++]=arr[j++];
		}
		while(i<=middle) 
		{
			temp[k++] = arr[i++];
		}


		i = start;
		k = 0;

		while (k < temp.length && i <= end)
			arr[i++]=temp[k++];
	}

	/*
    private static void Merge_Sort(int[] arr,int start,int end)
	{
		if(start < end)
		{
			int middle = (start + end) /2;
			Merge_Sort(arr,start,middle);
			Merge_Sort(arr,middle+1,end);

			int[] A = new int[middle-start+1];
			int[] B = new int[end-(middle+1)+1];


			for(int i=0;i<A.length;i++)
			A[i] = arr[start+i];

			for(int i=0;i<B.length;i++)
			B[i] = arr[middle+1+i];

			int[] C = Merge(A,B);


			for(int i=0;i<C.length;i++)
				arr[start+i] = C[i];
		}
	}

	private static int[] Merge(int[] A,int[] B)
	{
		int[] C = new int[A.length+B.length];
		int i=0, j=0, k=0;
		while(i<A.length && j<B.length)
		{
			if(A[i] <= B[j])
				C[k++] = A[i++];
			else
				C[k++] = B[j++];
		}
		while ( i < A.length)
			C[k++] = A[i++];

		while ( j < B.length)
			C[k++] = B[j++];
		return C;
	}
	 */
}



