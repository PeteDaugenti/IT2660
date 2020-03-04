import javax.xml.soap.Node;

public class SinglyLinkedList {
	
	private Node h;
	
	public SinglyLinkedList() {
		h = new Node();
		h.l = null;
		h.next = null;
	}
	
	public void insert(Listing newListing) {
		Node n = new Node();
		n.next = h.next;
		h.next = n;
		n.l = newListing.deepCopy();
	}
	
	public Listing fetch(String targetKey) {
		Node p = h.next;
		while(p != null && !(p.l.compareTo(targetKey) == 0)){
			p = p.next;
		}
		if(p != null) 
			return p.l.deepCopy();
		else
			return null;	
	}
	
	public boolean delete(String targetKey) {
		Node q = h;
		Node p = h.next;
		while(p != null && !(p.l.compareTo(targetKey)==0 )) {
			q = p;
			p = p.next;
		}
		if(p != null) {
			q.next = p.next;
			return true;
		}else {
			return false;
		}
	}
	
	public void update(String targetKey, Listing newListing) {
		if(!delete(targetKey)) {
			
		}else {
			insert(newListing);
		}
	}
	
	public void showAll() {
		Node p = h.next;
		while(p != null) {
			System.out.println(p.l.toString());
			p = p.next;
		}
	}
	public class Node{
		private Listing l;
		private Node next;
		
		public Node() {
			
		}
	}
}
