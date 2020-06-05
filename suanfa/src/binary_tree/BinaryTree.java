package binary_tree;

public class BinaryTree {
	private Node root;
	private Node pre;
	public void prevOrder() {
		if(root!=null) {
			root.prevOrder();
		}else {
			System.out.println("��Ϊ�ա��޷���ӡ");
		}
	}
	public void infixOrder() {
		if(root!=null) {
			root.infixOrder();
		}else {
			System.out.println("��Ϊ�ա��޷���ӡ");
		}
	}
	public void postOrder() {
		if(root!=null) {
			root.postOrder();
		}else {
			System.out.println("��Ϊ�ա��޷���ӡ");
		}
	}
	public Node prevSearch(int no) {
		if(root!=null) {
			return root.prevSearch(no);
		}else {
			return null;
		}
	}
	public Node infixSearch(int no) {
		if(root!=null) {
			return root.infixSearch(no);
		}else {
			return null;
		}
	}
	public Node postSearch(int no) {
		if(root!=null) {
			return root.postSearch(no);
		}else {
			return null;
		}
	}
	public Node delNode(int no) {
		if(root!=null) {
			if(root.getNo()==no) {
				return root;
			}else {
				return root.delNode(no);
			}
		}else {
			System.out.println("��Ϊ�ա��޷�ɾ��");
			return null;
		}
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public void prevThreadedTree(Node cur) {
		if(cur==null) {
			return;
		}
		if(cur.getLeft()==null) {
			cur.setLeft(pre);
			cur.setLeftType(1);
		}
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(cur);
			pre.setRightType(1);
		}
		pre=cur;
		if(cur.getLeftType()==0) {
			prevThreadedTree(cur.getLeft());
		}
		if(cur.getRightType()==0) {
			prevThreadedTree(cur.getRight());
		}
	}
	public void prevThreadedTreeList() {
		if(root==null) {
			return;
		}
		Node node=root;
		while(node!=null) {
			while(node.getLeft()!=null && node.getLeftType()==0) {
				System.out.println(node);
				node=node.getLeft();
			}
			System.out.println(node);
//			if(node.getLeftType()==1) {
				node=node.getRight();
//			}
//			while(node!=null) {
//				if(node.getLeft()!=null && node.getLeftType()==0) {
//					break;
//				}
//				System.out.println(node);
//				node=node.getRight();
//			}
		}
	}
	public void infixThreadedTree(Node cur) {
		if(cur==null) {
			return;
		}
		infixThreadedTree(cur.getLeft());
		if(cur.getLeft()==null) {
			cur.setLeft(pre);
			cur.setLeftType(1);
		}
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(cur);
			pre.setRightType(1);
		}
		pre=cur;
		infixThreadedTree(cur.getRight());
	}
	public void infixThreadedTreeList() {
		Node node=root;
		while(node!=null) {
			while(node.getLeftType()==0) {
				node=node.getLeft();
			}
			System.out.println(node);
			while(node.getRightType()==1) {
				node=node.getRight();
				System.out.println(node);
			}
			node=node.getRight();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		Node root = new Node(1,"�ν�");
		Node n1 = new Node(2,"����");
		Node n2 = new Node(3,"¬����");
		Node n3 = new Node(4,"�ֳ�");
		Node n4 = new Node(5,"��ʤ");
		Node n5 = new Node(6,"66");
		tree.setRoot(root);
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n4);
		n1.setRight(n3);
		n2.setLeft(n5);
		tree.infixOrder();
		System.out.println();
		tree.prevOrder();
		System.out.println();
		tree.prevThreadedTree(root);
		tree.prevThreadedTreeList();
	}
}
class Node{
	private int no;
	private String name;
	private Node left;
	private Node right;
	private int leftType;
	private int rightType;
	public Node(int no,String name) {
		this.setNo(no);
		this.setName(name);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public String toString() {
		return "Node [no="+no+",name="+name+"]";
	}
	//ǰ�����
	public void prevOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.prevOrder();
		}
		if(this.right!=null) {
			this.right.prevOrder();
		}
	}
	//�������
	public void infixOrder() {
		if(this.left!=null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	//�������
	public void postOrder() {
		if(this.left!=null) {
			this.left.postOrder();
		}
		if(this.right!=null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	//ǰ�����
	public Node prevSearch(int no) {
		if(this.no==no) {
			return this;
		}
		Node temp = null;
		if(this.left!=null) {
			temp=this.left.prevSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		if(this.right!=null) {
			temp = this.right.prevSearch(no);
		}
		return temp;
	}
	//�������
	public Node infixSearch(int no) {
		Node temp = null;
		if(this.left!=null) {
			temp = this.left.infixSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		if(this.no==no) {
			return this;
		}
		if(this.right!=null) {
			temp= this.right.infixSearch(no);
		}
		return temp;
	}
	//�������
	public Node postSearch(int no) {
		Node temp = null;
		if(this.left!=null) {
			temp= this.left.postSearch(no);
		}
		if(temp!=null) {
			return temp;
		}
		if(this.right!=null) {
			temp =  this.right.postSearch(no);
		}
		if(this.no==no) {
			return this;
		}
		return temp;
	}
	public Node delNode(int no) {
		Node temp =null;
		if(this.left!=null && this.left.no==no) {
			temp=this.left;
			if(temp.left !=null) {
				this.left=temp.left;
			}else if(temp.right!=null) {
				this.left=temp.right;
			}else {
				this.left=null;
			}
			return temp;
		}
		if(this.right!=null && this.right.no==no) {
			temp=this.right;
			if(temp.left !=null) {
				this.right=temp.left;
			}else if(temp.right!=null) {
				this.right=temp.right;
			}else {
				this.right=null;
			}
			return temp;
		}
		if(this.left!=null) {
			this.left.delNode(no);
		}
		if(this.right!=null) {
			this.right.delNode(no);
		}
		return temp;
	}
	public int getLeftType() {
		return leftType;
	}
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
}