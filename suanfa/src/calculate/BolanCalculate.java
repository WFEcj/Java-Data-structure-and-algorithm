package calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BolanCalculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "(51+2)*2";
		int res = bolanCalculate(msg);
		System.out.println(res);
	}
	public static int bolanCalculate(String msg) {
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		Stack<String> s = new Stack<>();
		Stack<String> s2 = new Stack<>();
		int index = 0;
		int res = 0;
		char ch;
		int len = msg.length();
		while(index!=len) {
			ch = msg.charAt(index);
			StringBuffer str = new StringBuffer();
			if(ch <48 || ch>57) {
				str.append(ch);
				index++;
			}else {
				while(index<len && (ch=msg.charAt(index)) >=48 && (ch = msg.charAt(index)) <=57) {
					str.append(ch);
					index++;
				}
			}
			list.add(str.toString());
		}
		System.out.println(list);
		for(String value:list) {
			if(value.matches("\\d+")) {
				list2.add(value);
			}else if(value.equals("(")) {
				s.push(value);
			}else if(value.equals(")")) {
				while(!s.peek().equals("(")) {
					list2.add(s.pop());
				}
				s.pop();
			}else {
				while(!s.isEmpty() && priority(value)<=priority(s.peek())) {
					list2.add(s.pop());
				}
				s.push(value);
			}
		}
		while(!s.isEmpty()) {
			list2.add(s.pop());
		}
		System.out.println(list2);
		for(String value:list2) {
			if(value.matches("\\d+")) {
				s2.push(value);
			}else {
				res = calculate(s2.pop(),s2.pop(),value);
				s2.push(res+"");
			}
		}
		return res;
	}
	static int calculate(String s1,String s2,String oper) {
		int number1 = Integer.parseInt(s1);
		int number2 = Integer.parseInt(s2);
		int res = 0;
		switch(oper) {
		case "+":res = number2 + number1;
			break;
		case "-":res = number2 - number1;
			break;
		case "*":res = number2 * number1;
			break;
		case "/":res = number2 / number1;
			break;
		default:System.out.println("运算符有误！");
			break;
		}
		return res;
	}
	static int priority(String s) {
		int pri = 0;
		switch(s) {
		case "*":
		case "/":pri=2;
			break;
		case "+":
		case "-":pri=1;
			break;
		default:pri=0;
			break;
		}
		return pri;
	}
}
