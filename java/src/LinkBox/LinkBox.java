package LinkBox;
import ArrayBox.BoxIndexOutOfBoundsException;
public class LinkBox implements Box{
	private Node first;
	private int size;
	private Node last;
	private void linkLast(int element) {
		//Node l=last;
		Node newNode=new Node(last,element,null);
		
		if(last==null) {
			first=newNode;
		}else {
			last.next=newNode;
		}
		last = newNode;
		this.size++;
	}
	private void rangeCheck(int index) {
		if(index<0 || index>=size) {
			throw new BoxIndexOutOfBoundsException("index:"+index+",size:"+size);
		}
	}
	private Node node(int index) {
		Node targetNode;
		if(index<(size>>1)) {
			targetNode=first;
			for(int i=0;i<index;i++) {
				targetNode=targetNode.next;
			}
		}else {
			targetNode=last;
			for(int i=size-1;i>index;i--) {
				targetNode=targetNode.prev;
			}
		}
		return targetNode;
	}
	private int unLink(Node targetNode) {
		int oldValue=targetNode.item;
		Node prev=targetNode.prev;
		Node next=targetNode.next;
		if(prev==null) {
			first=next;
		}else{
			prev.next=next;
			targetNode.next=null;
		}
		if(next==null) {
			last=prev;
		}else {
			next.prev=prev;
			targetNode.prev=null;
		}
		this.size--;
		return oldValue;
	}
	//==================================================
	public boolean add(int element) {
		// TODO Auto-generated method stub
		this.linkLast(element);
		return true;
	}
	public int get(int index) {
		// TODO Auto-generated method stub
		this.rangeCheck(index);
		Node targetNode=this.node(index);
		return targetNode.item;
	}
	public int remove(int index) {
		// TODO Auto-generated method stub
		this.rangeCheck(index);
		Node node=this.node(index);
		int oldValue=this.unLink(node);
		return oldValue;
	}
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
}