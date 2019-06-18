import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {101,200,300,1,02,3,102,300,415,951};
		radixsort(arr,3);
		System.out.println(Arrays.toString(arr));
	}
	public static void radixsort(int[] arr, int d)
	{
		int[] arr2 = new int[arr.length];
		for(int i=0;i<d;i++)
		{
			int index=0;
			for(int k=0;k<10;k++)
			{
				for(int j=0;j<arr.length;j++)
				{
					if(digitAt(arr[j],i)==k) arr2[index++]=arr[j];
				}	
			}
		}
		for(int k=0; k<arr.length; k++)
			arr[k] = arr2[k];
	}
	public static int digitAt(int num, int d)
	{
		for(int i=0;i<d;i++)
		{
			num/=10;
		}
		return num%10;
	}

}
