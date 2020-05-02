
public class Main {
	
	public static void main(String[] args) {
		
		BinaryTree t = new BinaryTree();
		
		Listing l1 = new Listing("Charles", "5556", "3.6" );
		Listing l2 = new Listing("Rachel", "5557", "3.2");
		Listing l3 = new Listing("Prince", "5544", "2.8");
		
		// insert
		t.insert(l1);
		t.insert(l2);
		t.insert(l3);
		t.showAll();
		
		// fetch 
		l3 = t.fetch("Prince");
		System.out.println(l3.toString());
		
		// delete method
		t.delete("Rachel");
		t.showAll();
		
		// update method
		t.update("Prince", l2);
		t.showAll();
		System.exit(0);
	}
}
