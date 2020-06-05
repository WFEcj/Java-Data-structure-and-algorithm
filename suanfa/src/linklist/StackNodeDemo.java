package linklist;

public class StackNodeDemo {
	private StackNode head = new StackNode(-1);
	private StackNode cur = head;
	public StackNodeDemo() {
		head.setNext(null);
	}
	public void push(int no) {
		StackNode newNode = new StackNode(no);
		cur.setNext(newNode);
		cur=newNode;
	}
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("栈为空~~无法打印1~");
			return -1;
		}
		int value = cur.getNo();
		StackNode temp = head;
		while(true) {
			if(temp.getNext()==cur) {
				break;
			}
			temp=temp.getNext();
		}
		temp.setNext(null);
		cur=temp;
		return value;
	}
	public int peek() {
		if(this.isEmpty()) {
			System.out.println("栈为空~~无法打印~");
			return -1;
		}
		return cur.getNo();
	}
	public void showStackNode() {
		if(this.isEmpty()) {
			System.out.println("栈为空~~无法打印~");
			return;
		}
		int i = 0;
		StackNode temp = head;
		while(temp.getNext()!=null) {
			temp=temp.getNext();
			System.out.printf("StackNode[%d]=%d",i,temp.getNo());
			System.out.println();
			i++;
		}
	}
	private boolean isEmpty() {
		if(head.getNext()==null) {
			return true;
		}
		return false;
	}
	public int operIp(char oper) {
		if(oper=='*' || oper=='/') {
			return 1;
		}else if(oper=='+' || oper=='-') {
			return 0;
		}else {
			return -1;
		}
	}
	public int calculate(int num1,int num2,char oper) {
		int res=0;
		switch(oper) {
		case'*':res=num1*num2;
		break;
		case'/':res=num2/num1;
		break;
		case'+':res=num2+num1;
		break;
		case'-':res=num2-num1;
		break;
		default:break;
		}
		return res;
	}
	public static void main(String[] args) {
		StackNodeDemo numStack = new StackNodeDemo();
		StackNodeDemo operStack = new StackNodeDemo();
		String message = "30+2*5-3";
		int num1=0;
		int num2=0;
		int res=0;
		int index=0;
		int oper=0;
		char ch=' ';
		String keyNum = "";
		while(true) {
			ch=message.substring(index,index+1).charAt(0);
			if(operStack.operIp(ch)==-1) {
				keyNum+=ch;
				if(index==message.length()-1) {
					numStack.push(Integer.parseInt(keyNum));
				}else {
					if(operStack.operIp(message.substring(index+1,index+2).charAt(0))!=-1) {
						numStack.push(Integer.parseInt(keyNum));
						keyNum="";
					}
				}
			}
			else{
				if(operStack.isEmpty() || operStack.operIp(ch)>=operStack.operIp((char)operStack.peek())) {
					operStack.push(ch);
				}else{
					num1=numStack.pop();
					num2=numStack.pop();
					oper=operStack.pop();
					res=operStack.calculate(num1, num2, (char)oper);
					numStack.push(res);
					operStack.push(ch);
				}
			}
			index++;
			if(index>=message.length()) {
				break;
			}
		}
		while(!operStack.isEmpty()) {
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=operStack.calculate(num1, num2, (char)oper);
			numStack.push(res);
		}
		System.out.println(res);
	}
}
class StackNode{
	private int no;
	private StackNode next;
	public StackNode(int no) {
		this.setNo(no);
	}
	public StackNode getNext() {
		return next;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}