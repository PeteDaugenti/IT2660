import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class BinaryTree {
	TreeNode root;
	
	public BinaryTree() {
		root = null;
		
	}
	
	public boolean insert (Listing newListing) {
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		TreeNode n = new TreeNode();
		
		if (n == null)
			return false;
		else {
			n.node = newListing.deepCopy();
			n.leftC = null;
			n.rightC = null;
			
			if(root == null) {
				root = n;
			}else {
				findNode(newListing.getKey(), p, c);
				if(newListing.getKey().compareTo(p.get().node.getKey()) < 0)
					p.get().leftC = n;
				else
					p.get().rightC = n;
			}
			
			return true;
		}
	}
	
	public Listing fetch(String targetKey) {
		boolean found;
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		found = findNode(targetKey, p, c);
		
		if(found == true)
			return c.get().node.deepCopy();
		else
			return null;
	}
	
	public boolean delete(String targetKey) {
		boolean found;
		TreeNodeWrapper p = new TreeNodeWrapper();
		TreeNodeWrapper c = new TreeNodeWrapper();
		TreeNode largest;
		TreeNode nextLargest;
		found = findNode(targetKey, p, c);
		
		if(found == false)
			return false;
		else {
			
			if(c.get().leftC == null && c.get().rightC == null) {
				
				if(p.get().leftC == c.get())
					p.get().leftC = null;
				else
					p.get().rightC = null;
			}
			else if(c.get().leftC == null || c.get().rightC == null) {
				
				if(p.get().leftC == c.get()) {
					
					if(c.get().leftC != null)
						p.get().leftC = c.get().leftC;
					else
						p.get().rightC = c.get().rightC;
				}else {
					
					if(c.get().leftC != null)
						p.get().rightC = c.get().leftC;
					else
						p.get().rightC = c.get().rightC;
				}
			}else {
				
				nextLargest = c.get().leftC;
				largest = nextLargest.rightC;
				
				if(largest != null) {
					while(largest.rightC != null) {
						nextLargest = largest;
						largest = largest.rightC;
					}
					c.get().node = largest.node;
					nextLargest.rightC = c.get().rightC;
				}else {
					nextLargest.rightC = c.get().rightC;
					
					if(p.get().leftC == c.get())
						p.get().leftC = nextLargest;
					else
						p.get().rightC = nextLargest;
				}
			}
			
			return true;
		}
	}
	
	public boolean update (String targetKey, Listing newListing) {
		
		if(delete(targetKey) == false)
			return false;
		else if(insert(newListing) == false)
			return false;
		
		return true;
	}
	
	public class TreeNode{
		
		private Listing node;
		private TreeNode leftC;
		private TreeNode rightC;
		
		public TreeNode() {
			
		}
	}
	
	private boolean findNode (String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child) {
		
		parent.set(root);
		child.set(root);
		
		if(root == null)
			return true;
		
		while(child.get() != null) {
			
			if(child.get().node.compareTo(targetKey) == 0)
				return true;
			else {
				parent.set(child.get());
				
				if(targetKey.compareTo(child.get().node.getKey()) < 0)
					child.set(child.get().leftC);
				else
					child.set(child.get().rightC);
			}
		}
		
		return false;
	}
	
	public class TreeNodeWrapper{
		
		TreeNode treeRef = null;
		public TreeNodeWrapper() {
			
		}
		
		public TreeNode get() {
			return treeRef;
		}
		
		public void set(TreeNode t) {
			treeRef = t;
		}
	}
	
	public void LNRoutputTraversal(TreeNode root) {
		
		if(root.leftC != null) {
			
			LNRoutputTraversal(root.leftC);
		}
		System.out.println(root.node);
		
		if(root.rightC != null) {
			LNRoutputTraversal(root.rightC);
		}
	}
	
	public void showAll() {
		
		if(root == null) {
			System.out.println("Data structure is empty");
		}else {
			LNRoutputTraversal(root);
		}
	}
}
