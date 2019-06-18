public class MyTree {
	TNode root;

	//Search Function//
	public boolean search(int data)
	{
		return search(data,root);
	}
	public boolean search(int data, TNode T)
	{
		if(T == null) return false;
		else if(T.getData() == data) return true;
		else if(data > T.getData()) 
			return search(data,T.getRight());
		else
			return search(data,T.getLeft());
	}
	//Search Function//
	//Insert Function//
	public void insert(int data)
	{
		TNode temp = new TNode(data);
		if(root==null) root = temp;
		else
		{
			TNode current = root;
			boolean flag = false;
			while(!flag)
			{
				if(data < current.getData())
				{
					if(current.getLeft() == null)
					{
						current.setLeft(temp);
						temp.setFather(current);
						flag = true;
					}
					else
					{
						current = current.getLeft();
					}
				}
				else
				{
					if(current.getRight() == null)
					{
						current.setRight(temp);
						temp.setFather(current);
						flag=true;
					}
					else
						current = current.getRight();
				}
			}
		}
	}
	//Insert Function//
	
	//Delete Function//
	public boolean delete(int data)
	{
		if(search(data) == false) return false;
		
		TNode current  = root;
		while(current.getData() != data)
		{
			if(data > current.getData())
				current = current.getRight();
			else
				current = current.getLeft();
		}
		TNode father = current.getFather();
		
		//case 1 : leaf
		if(current.getLeft() == null && current.getRight()==null)
		{
			if(father==null)
				root=null;
			else if(data > father.getData())
				father.setRight(null);
			else
				father.setLeft(null);
		}
		// case 2: current has only one child
		else if ( current.getLeft() == null)
		{
			if(father==null)
			{
				root = current.getRight();
				root.setFather(null);
			}
			else if(data > father.getData())
			{
				father.setRight(current.getLeft());
				current.getLeft().setFather(father);
			}
			else
			{
				father.setLeft(current.getRight());
				current.getRight().setFather(father);
			}
		}
		// case 3: current has two children
		else
		{
			//find replacment - largest on the left side
			TNode replace = current.getLeft();
			while(replace.getRight()!=null)
				replace = replace.getRight();
			delete(replace.getData());
			// replace data
			current.setData(replace.getData());
			
		}
		return true;
	}
	//Delete Function//

	
	
	//Print Function//\
	public  void printTree()
	{
	printTree(root,0);	
	}
	private static void printTree(TNode root, int level)
	{
	    if(root==null)
	         return;
	    printTree(root.getRight(), level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.getData());
	    }
	    else
	        System.out.println(root.getData());
	   printTree(root.getLeft(), level+1);
	}    

}