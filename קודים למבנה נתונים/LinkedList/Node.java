package LinkedList;
public class Node {
	Object data;
	Node next;

	public Node(Object data)
	{
		this.data = data;
		next = null;
	}
	public Node(Object data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	public String toString()
	{
		return "" + data;
	}
	public Object getData()
	{
		return this.data;
	}
	public Node getNext()
	{
		return next;
	}
	public void setNext(Node next)
	{
	this.next = next;
	}
}