package calculate;

public class MidFormCalculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "10+2*5-5";
		System.out.println(calculate(msg));
	}
	public static int calculate(String msg) {
		ArrayStack operStack = new ArrayStack(10);
		ArrayStack numStack = new ArrayStack(10);
		int index = 0;
		int number1;
		int number2;
		int oper;
		int res = 0;
		char ch;
		while(index!=msg.length()) {
			StringBuffer str = new StringBuffer();
			ch = msg.charAt(index);
			if(ch<48 || ch>57) {
				if(operStack.isEmpty()) {
					operStack.push(ch);
				}else {
					if(operStack.priority(ch)>operStack.priority((char)operStack.peek())) {
						operStack.push(ch);
					}else {
						number1 = numStack.pop();
						number2 = numStack.pop();
						oper = operStack.pop();
						res = calculate(number1,number2,oper);
						numStack.push(res);
					}
				}
				index++;
			}else {
//				str.append(ch);
//				int i = index+1;
//				while(i<msg.length()) {
//					char ch2 = msg.charAt(i);
//					if(ch2>=48 && ch<=57) {
//						str.append(ch2);
//						index++;
//						i++;
//					}else {
//						break;
//					}
//				}
				while(index<msg.length() && (ch = msg.charAt(index)) >=48 && (ch = msg.charAt(index))<= 57) {
					str.append(ch);
					index++;
				}
				numStack.push(Integer.parseInt(str.toString()));
			}
		}
		while(!operStack.isEmpty()) {
			number1 = numStack.pop();
			number2 = numStack.pop();
			oper = operStack.pop();
			res = calculate(number1,number2,oper);
			numStack.push(res);
		}
		return res;
	}
	public static int calculate(int number1,int number2,int oper) {
		int res = 0;
		switch(oper) {
		case '+':res = number1 + number2;
			break;
		case '-':res = number2 - number1;
			break;
		case '*':res = number1 * number2;
			break;
		case '/':res = number2 / number1;
			break;
		default:System.out.println("操作符有误！");
			res=-1;
			break;
		}
		return res;
	}
}
class ArrayStack{
	int maxSize;
	int top;
	int[] arrayStack;
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		arrayStack = new int[maxSize];
		this.top = -1;
	}
	public void push(int number) {
		if(isFull()) {
			throw new RuntimeException("栈满");
		}
		arrayStack[++top] = number;
	}
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return arrayStack[top];
	}
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈空");
		}
		return arrayStack[top--];
	}
	
	public int priority(char oper) {
		if(oper=='*' || oper=='/') {
			return 2;
		}else if(oper=='+' || oper=='-') {
			return 1;
		}else {
			throw new RuntimeException("操作符有误！");
		}
	}
	private boolean isFull() {
		return top==maxSize-1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	
}