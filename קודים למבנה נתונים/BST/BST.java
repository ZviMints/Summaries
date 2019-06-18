package BST;
public class BST<T>
{
	Node root;
	public int returnMin()
	{
		Node current = root;
		while (current.left != null)
			current = current.left;
		return  current.data;
	}
	public int returnMax()
	{
		Node current = root;
		while (current.right != null)
			current = current.right;
		return  current.data;
	}
	public boolean search(int key)
	{
		Node current = root;
		while(current.left != null)
		{
			if(current.data == key) return true;
			else if(key == current.data )
				current = current.right;
			else
				current = current.left;
		}
		return false;
	}
	public int getHeight()
	{
		return getHeight(root);	
	}
	public int getHeight(Node current)
	{
		int result = -1;
		if(current != null)
		{
			int LeftHeight = getHeight(current.left);
			int RightHeight = getHeight(current.right);
			result = Integer.max(LeftHeight, RightHeight)+1;
		}
		return result;
	}

	public void PreOrder() // (V,L,R)
	{
		PreOrder(root);
	}
	public void PreOrder(Node current)
	{
		if(current != null)
		{
			System.out.print(current.data + " " );
			PreOrder(current.left);
			PreOrder(current.right);
		}
	}

	public void InOrder() // (L,V,R)
	{
		InOrder(root);
	}
	public void InOrder(Node current)
	{
		if(current != null)
		{
			InOrder(current.left);
			System.out.print(current.data + " " );
			InOrder(current.right);
		}
	}
	
	public void PostOrder() // (L,R,V)
	{
		PostOrder(root);
	}
	public void PostOrder(Node current)
	{
		if(current != null)
		{
			PostOrder(current.left);
			PostOrder(current.right);
			System.out.print(current.data + " " );
		}
	}
	public void add(int key)
	{
		Node NewNode = new Node(key);
		Node current = root;
		if(current == null)
			root = NewNode;
		else
		{
			boolean exit = false;
			while(!exit)
			{
				if(key < current.data)
				{
					if(current.left == null)
					{
						// put here
						current.left = NewNode;
						exit = true;
					}
					else
						current = current.left;
				}
				else if(key > current.data)
				{
					if(current.right == null)
					{
						// put here
						current.right = NewNode;
						exit = true;
					}
					else
						current = current.right;
				}

			}
		}
	}
	public void printTree() {
		if( root != null) {
			printTree(root.right, true, "");
	                 System.out.println(root.data);
			printTree(root.left, false, "");

		}
	}

	private void printTree(Node node, boolean isRight, String indent) {
		 if(node != null) {
		  printTree(node.right, true, indent + (isRight ? "        " : " |      "));
	          System.out.print(indent);
	          if (isRight) System.out.print(" /");
        	  else System.out.print(" \\");
		  System.out.print("----- ");
		  System.out.println(node.data);
         	 printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}
	}
}
