package linklist2;

public class DbLinkList {
	private Node first;
	private int size;
	private Node last;
	private void linkNode(int element) {
		Node newNode = new Node(last,element,null);
		if(last==null) {
			first = newNode;
		}else {
			last.next = newNode;
		}
		last = newNode;
		this.size++;
	}
	private Node node(int index) {
		Node targetNode;
		if(index<(size>>1)) {
			targetNode = first;
			for(int i = 0;i<index;i++) {
				targetNode = targetNode.next;
			}
		}else {
			targetNode = last;
			for(int i = this.size-1;i>index;i--) {
				targetNode = targetNode.prev;
			}
		}
		return targetNode;
	}
	private int unLinkNode(Node node) {
		Node prev = node.prev;
		int oldValue = node.number;
		Node next = node.next;
		if(prev==null) {
			first=next;
		}else {
			prev.next=next;
		}
		if(next==null) {
			last=prev;
		}else {
			next.prev=prev;
		}
		
		this.size--;
		return oldValue;
	}
	private void rangeCheck(int index) {
		if(index<0 || index >=size) {
			throw new RuntimeException("索引有误！");
		}
	}
	//==============================================
	public boolean add(int element) {
		this.linkNode(element);
		return true;
	}
	public int delete(int index) {
		this.rangeCheck(index);
		return unLinkNode(node(index));
	}
	public int get(int index) {
		this.rangeCheck(index);
		return this.node(index).number;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbLinkList dbLink = new DbLinkList();
		dbLink.add(1);
		dbLink.add(2);
		System.out.println(dbLink.get(0));
		
		
		System.out.println(dbLink.delete(1));
//		System.out.println(dbLink.get(1));
	}

}
class Node{
	Node prev;
	int number;
	Node next;
	public Node(Node prev,int number,Node next) {
		this.prev = prev;
		this.number = number;
		this.next = next;
	}
}