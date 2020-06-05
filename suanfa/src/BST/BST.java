package BST;

public class BST {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,3,10,12,5,1,9};
		Node root = null;
		for(int n:arr) {
			if(root == null) {
				root = new Node(n);
				continue;
			}
			Node cur = root;
			Node par = null;
			while(cur != null) {
				par = cur;
				if(n < cur.val) cur = cur.left;
				else cur = cur.right;
			}
			if(n < par.val) par.left = new Node(n);
			else par.right = new Node(n);
			if(height(root.left) - height(root.right) > 1) {
				if(height(root.left.right) > height(root.left.left)) leftRotate(root.left);
				rightRotate(root);
			}
			if(height(root.right) - height(root.left) > 1) {
				if(height(root.right.left) > height(root.right.right)) rightRotate(root.right);
				leftRotate(root);
			}
		}
		//infixOrder(root);
//		del(root,7);
//		infixOrder(root);
		//del(root,5);
		//del(root,5);
		infixOrder(root);
	}
	private static void rightRotate(Node root) {
		Node cur = new Node(root.val);
		cur.right = root.right;
		cur.left = root.left.right;
		root.val = root.left.val;
		root.left = root.left.left;
		root.right = cur;
	}
	private static void leftRotate(Node root) {
		Node cur = new Node(root.val);
		cur.left = root.left;
		cur.right = root.right.left;
		root.val = root.right.val;
		root.right = root.right.right;
		root.left = cur;
	}
	private static int height(Node node) { 
		if(node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	public static boolean add(Node node,int val) {
		if(node == null) {
			node = new Node(val);
			return true;
		}
		if(node.val == val) return false;
		if(node.val > val) return add(node.left,val);
		return add(node.right,val);
	}
	public static void infixOrder(Node root) {
		if(root == null) return;
		infixOrder(root.left);
		System.out.println(root.val);
		infixOrder(root.right);
	}
	public static Node del(Node root,int val) {
		Node par = null;
		Node cur = root;
		while(cur != null) {
			if(cur.val == val) break;
			par = cur;
			if(cur.val > val) cur = cur.left;
			else cur = cur.right;
		}
		if(cur != null) {
			if(cur.left != null && cur.right != null) {
				Node target = find_min(cur.right);
				del(root,target.val);
				cur.val = target.val;
			} else if(cur.left == null && cur.right == null) {
				if(par == null) root = null;
				else {
					if(par.left == cur) {
						par.left = null;
					} else {
						par.right = null;
					}
				}
			} else {
				if(par == null) {
					if(cur.left != null) root = cur.left;
					else root = cur.right;
				} else {
					if(par.left == cur) {
						if(cur.left != null) par.left = cur.left;
						else par.left = cur.right;
					} else {
						if(cur.left != null) par.right = cur.left;
						else par.right = cur.right;
					}
				}
			}
			
		}
		return cur;
	}
	private static Node find_min(Node node) {
		Node cur = node;
		while(cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}
}
//树的节点
class Node{
	int val;
	Node left;
	Node right;
	Node parent;
	public Node(int val) {
		this.val = val;
	}
}
