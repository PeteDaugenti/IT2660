import javax.swing.*;

public class Listing {
	private String name; // key field
	private String id;
	private String gpa;
	
	public Listing(String n, String j, String k) {
		name = n;
		id = j;
		gpa = k;
	}
	
	public String toString() {
		return ("Name is " +name+ "\nIdentification is " +id+ "\nGPA is " +gpa);
	}
	
	public Listing deepCopy() {
		Listing clone = new Listing(name, id, gpa);
		return clone;
	}
	
	public int compareTo(String targetKey) {
		return (name.compareTo(targetKey));
	}
	
	public void setId(String j){
		id = j;
	}
} 
