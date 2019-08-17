package LinkedList;
public class LinkedList {
	private Node head;
	int size;

	public LinkedList()
	{
		head = null;
		size = 0;
	}
	public String toString()
	{
		if(head == null)
			return "[]";
		String result ="[";
		Node current = head;
		while(current != null)
		{
			result = result + current.getData() + " ";
			current = current.getNext();
		}
		result = result + "]";
		return result;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return (head==null);
	}
	public void add(Object key)
	{
		Node NewNode = new Node(key);
		if(head == null)
		{
			head = NewNode; 
		}
		else
		{
			Node current = head;
			while ( current.getNext() != null)
			{
				current = current.getNext();
			}
			current.setNext(NewNode);
			size++;
		}
	}
	public boolean remove(Object key)
	{
		Node current = head;
		while(current.getNext() != null)
		{
			if(current.getNext().getData() == key)
			{
			size--;
			current.setNext(current.getNext().getNext());
			return true;
			}
			current = current.getNext();
		}
		return false;
	}
	public boolean contains(Object key)
	{
		Node current = head;
		while(current != null)
		{
			if(current.getNext().getData() == key)
			{
			return true;
			}
			current = current.getNext();
		}
		return false;
	}
	}

