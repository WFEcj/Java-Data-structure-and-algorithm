package linklist;

public class CircleLinkList {
	private Node1 first=null;
	private Node1 curNode=null;
	private int size;
	public CircleLinkList(int n) {
		this.size=n;
		for(int i =0;i<n;i++) {
			if(first==null) {
				first=new Node1(i+1);
				first.setNext(first);
				curNode=first;
				continue;
			}
			Node1 newNode=new Node1(i+1);
			curNode.setNext(newNode);
			newNode.setNext(first);
			curNode=curNode.getNext();
		}
	}
	public void showNode() {
		if(first==null) {
			System.out.println("链表为空！！无法打印！");
			return;
		}
		Node1 helpNode = first;
		do {
			System.out.printf("Node:%d",helpNode.getNo());
			System.out.println();
			helpNode=helpNode.getNext();
		}while(helpNode!=first);
	}
	public void getNodeByYsf(int startNo,int countNum,int nums) {
		if(first==null || startNo<1 || startNo>nums) {
			System.out.println("数据有误！");
			return;
		}
		Node1 helper=first;
		while(true) {
			if(helper.getNext()==first) {
				break;
			}
			helper = helper.getNext();
		}
		for(int i =0;i<startNo-1;i++) {
			first=first.getNext();
			helper=helper.getNext();
		}
		while(true) {
			if(first==helper) {
				break;
			}
			for(int j = 0;j<countNum-1;j++) {
				first=first.getNext();
				helper=helper.getNext();
			}
			System.out.printf("Node:%d",first.getNo());
			System.out.println();
			first=first.getNext();
			helper.setNext(first);
		}
		System.out.printf("Node:%d",first.getNo());
	}
	public static void main(String[] args) {
		CircleLinkList c = new CircleLinkList(5);
		c.showNode();
		System.out.println();
		c.getNodeByYsf(1, 2, 5);
	}
}
class Node1{
	private int no;
	private Node1 next;
	public Node1(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Node1 getNext() {
		return next;
	}
	public void setNext(Node1 next) {
		this.next = next;
	}
}