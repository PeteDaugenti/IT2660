
public class Main {
	public static void main(String[] args) {
		
		SinglyLinkedList test = new SinglyLinkedList();
		Listing l1 = new Listing("Charles", "5556", "3.6" );
		Listing l2 = new Listing("Rachel", "5557", "3.2");
		Listing l3 = new Listing("Prince", "5544", "2.8");
		
		// insert method
		test.insert(l1);
		test.insert(l2);
		test.insert(l3);
		test.showAll();
		
		// fetch method
		l3 = test.fetch("Prince");
		System.out.println(l3.toString());
		
		// delete method
		test.delete("Rachel");
		test.showAll();
		
		// update method
		test.update("Prince", l2);
		test.showAll();
		System.exit(0);
	}
}
