package linklist2;

public class LinkList {
	HeroNode head = new HeroNode(0,"","");
	public void addNode(HeroNode node) {
		HeroNode temp = head;
		while(true) {
			if(temp.next==null) {
				temp.next = node;
				break;
			}
			if(temp.next.no>=node.no) {
				node.next = temp.next;
				temp.next = node;
				break;
			}
			temp = temp.next;
		}
	}
	public int size() {
		HeroNode cur = head.next;
		int length = 0;
		while(cur!=null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	public HeroNode getNode(int index) {
		HeroNode cur = this.head.next;
		for(int i =0;i<index;i++) {
			cur = cur.next;
		}
		return cur;
	}
	public LinkList reverse() {
		if(head.next==null || head.next.next==null) {
			return this;
		}
		LinkList l = new LinkList();
		int n = size();
		for(int i =0;i<n;i++) {
			HeroNode node = this.getNode(i);
			l.add(node, 0);
		}
		return l;
	}
	public void add(HeroNode node,int index) {
		if(index==0) {
			node.next = head.next;
			head.next = node;
			return;
		}
		HeroNode cur = head.next;
		for(int i = 0;i<index-1;i++) {
			cur = cur.next;
		}
		node.next = cur.next;
		cur.next = node;
	}
	public void list() {
		HeroNode temp = head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		HeroNode h1 = new HeroNode(1,"宋江","及时雨");
		HeroNode h2 = new HeroNode(2,"吴用","智多星");
		HeroNode h4 = new HeroNode(4,"林冲","豹子头");
		HeroNode h3 = new HeroNode(3,"卢俊义","玉麒麟");
		
		LinkList l = new LinkList();
		l.addNode(h1);
		l.addNode(h3);
		l.addNode(h2);
		l.addNode(h4);
		l.list();
		LinkList l2 = l.reverse();
		l2.list();
//		System.out.println(l.getNode(1));
		
	}
}
class HeroNode{
	int no;
	String name;
	String nickName;
	HeroNode next;
	public HeroNode(int no,String name,String nickName) {
		this.no=no;
		this.name = name;
		this.nickName = nickName;
	}
	public String toString() {
		return "[no:"+this.no+",name:"+this.name+",nickName:"+this.nickName+"]";
	}
}
