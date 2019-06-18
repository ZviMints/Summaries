public class MaxHeap {
	int[] heap;
	int size=0;
	public MaxHeap(int capacity)
	{
		if(capacity < 0 ) capacity = 0;
		heap = new int[capacity];
		size = 0;
	}

	public int parent(int i)
	{
		if (i < 1 ) return -1;
		else return (i)/2;
	}

	public int left(int i)
	{
		int answer = 2*i;
		if (answer > size-1 ) answer = -1;
		return answer;
	}

	public int right(int i)
	{
		int answer = 2*i + 1;
		if (answer > size-1 ) answer = -1;
		return answer;
	}	
	public boolean add(int key)
	{
		if(size+1 == heap.length) return false;
		else
		{
			heap[size+1] = key;
			size ++;
			SwapUp(size);
			return true;

		}
	}
	private void SwapUp(int index)
	{
		if(index != 1) // if its not the head
		{
			int parent = parent(index);  
			if(heap[parent] < heap[index])
			{
				swap(heap,parent,index);
				SwapUp(parent);
			}
		}
	}
	public void maxHeapify(int i) // down (remove_max)
	{
		int left = left(i);
		int right = right(i);
		int largest = i;
		if(left > 0 && heap[left] > heap[largest])
			largest = left;
		if(right > 0 && heap[right] > heap[largest])
			largest = right;
		if(largest != i)
		{
			swap(heap,largest,i);
			maxHeapify(largest);
		}
	}

	public int remove_max()
	{
		if(size == 0) return Integer.MAX_VALUE; // if the heap is empty
		else
		{
			swap(heap,1,size); // swap root with last item
			size--; // delete the root ( he is the last item at the heap )
			maxHeapify(1); //maxHeapify from root
		}
		return heap[size]; // will show what deleted
	}


	public void swap(int[] heap, int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public int GetMax()
	{
		return heap[1];
	}
}
