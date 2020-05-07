
public class Listing {

	private int number;
	boolean pushed;
	
	Listing(int value){
		
		number = value;
	}
	Listing(){
		
		
	}
	
	public int getListing() {
		
		return number;
	}
	
	public int getListing(int value) {
		
		return number = value;
	}
	
	public Listing deepCopy() {
		
		Listing clone = new Listing(number);
		return clone;
	}
	
	public boolean getPushed() {
		
		return pushed;
	}
	
	public void setPushed(boolean value) {
		
		pushed = value;
	}
	
	public void visit(int vertexNumber) {
		
		System.out.println(this);
	}
}
