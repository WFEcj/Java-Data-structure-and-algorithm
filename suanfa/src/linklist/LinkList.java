package linklist;

public class LinkList {
	public Node first;
	public Node last;
	public int size;
	public void add(int num,String name,String nickName) {
		Node l = last;
		Node newNode = new Node(num,name,nickName);
		last=newNode;
		if(l==null) {
			first=newNode;
		}else {
			l.next=new Node(num,name,nickName);
		}
		this.size++;
	}
	public void add(Node newNode) {
		Node l = last;
		last=newNode;
		if(l==null) {
			first=newNode;
		}else {
			l.next=newNode;
		}
		this.size++;
	}
	public void add(Node node,int index) {
		Node temp = first;
		this.size++;
		if(index==0) {
			first=node;
			node.next=temp;
			return;
		}
		for(int i =0;i<index-1;i++) {
			temp=temp.next;
		}
		node.next=temp.next;
		temp.next=node;
	}
	public void addByOrder(Node newNode) {
		Node temp = first;
		while(true) {
			if(temp==null) {
				this.add(newNode);
				break;
			}
			if(temp.num > newNode.num) {
				if(temp==first) {
					first=newNode;
					newNode.next=temp;
				}else {
					
				}
			}else if(temp.num==newNode.num) {
				
			}
		}
	}
	public Node get(int index) {
		this.rangeCheck(index);
		Node targetNode=first;
		for(int i =0;i<index;i++) {
			targetNode= targetNode.next;
		}
		return targetNode;
	}
	public Node remove(int index) {
		this.rangeCheck(index);
		this.size--;
		Node temp = first;
		if(index==0) {
			first=temp.next;
			temp.next=null;
			return temp;
		}
		for(int i = 0;i<index-1;i++) {
			temp=temp.next;
		}
		Node targetNode = temp.next;
		temp.next=temp.next.next;
		temp.next.next=null;
		return targetNode;
	}
	public LinkList reverse() {
		LinkList newl = new LinkList();
		int n=this.Size();
		for(int i =0;i<n;i++) {
			Node targetNode = this.remove(0);
			if(newl.first==null) {
				newl.add(targetNode);
			}else {
				newl.add(targetNode,0);
			}
		}
		return newl;
	}
	public int Size() {
		return this.size;
	}
	private void rangeCheck(int index) {
		if(index<0 || index>=size) {
			throw new RuntimeException("index:"+index+",size:"+size);
		}
	}
	public static void main(String[] args) {
		LinkList l = new LinkList();
		l.add(0,"宋江","及时雨");
		l.add(1,"宋江2","及时雨");
		Node node0 = l.get(0);
		Node node1 = l.get(1);
		System.out.println(node0.name);
		System.out.println(node1.name);
		LinkList targetNode1 = l.reverse();
		Node node2 = targetNode1.get(0);
		Node node3 = targetNode1.get(1);
		System.out.println(node2.name);
		System.out.println(node3.name);
		System.out.println(targetNode1.Size());
	}
}
class Node{
	public int num;
	public String name;
	public String nickName;
	public Node next;
	public Node(int num,String name,String nickName) {
		this.num=num;
		this.name=name;
		this.nickName=nickName;
	}
}