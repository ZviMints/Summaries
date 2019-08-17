public class TNode {
	private TNode left,right,father;
	private int data;
	public TNode(int data)
	{
		this.data = data;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public int getData()
	{
		return this.data;
	}
	public void setLeft(TNode l)
	{
		this.left=l;
	}
	public void setRight(TNode r)
	{
		this.right = r;
	}
	public TNode getRight()
	{
		return this.right;
	}
	public TNode getLeft()
	{
		return this.left;
	}
	public void setFather(TNode t) 
	{
		father = t;
	}
	public TNode getFather()
	{
		return father;
	}
}
