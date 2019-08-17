package SemesterB;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args)
	{
		int[] arr = new int[9999];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*10 + 1);
		}
		long start_time = System.currentTimeMillis();
		InsertionSort(arr);
		long end_time = System.currentTimeMillis();
		long time=end_time-start_time;
		System.out.println(time);
		System.out.println(Arrays.toString(arr));
	}
	public static void InsertionSort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			int j=i;
			while(j>0 && arr[j-1]>arr[j])
			{
			int temp=arr[j];
			arr[j]=arr[j-1];
			arr[j-1]=temp;
			j=j-1;
			}
		}
	}
}
