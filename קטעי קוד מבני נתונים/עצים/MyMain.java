public class MyMain {

	public static void main(String[] args) {
		MyTree temp = new MyTree();
		temp.insert(2);
		temp.insert(1);
		temp.insert(7);
		temp.insert(6);
		temp.insert(4);
		temp.insert(3);
		temp.insert(115);
		temp.insert(0);
		temp.printTree();
		System.out.println();
		System.out.println();
		System.out.println();
		temp.delete(7);
		temp.printTree();
		
	}

}
