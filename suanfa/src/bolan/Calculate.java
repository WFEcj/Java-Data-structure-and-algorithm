package bolan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculate {
	public static void main(String[] args) {
		String message = "1*(2+3)-4";
		List<String> ls = new ArrayList<>();
		List<String> boLanExpression = new ArrayList<>();
		Stack<String> s1 = new Stack<>();
		Stack<String> s2 = new Stack<>();
		String key = "";
		int num1;
		int num2;
		int res = 0;
		int i =0;
		int j =0;
		char ch;
		while(i!=message.length()) {
			if((ch=message.charAt(i))<48 || (ch=message.charAt(i))>57) {
				ls.add(""+ch);
				i++;
			}else {
				while(i<message.length() && (ch=message.charAt(i))>=48 && (ch=message.charAt(i))<=57) {
					key+=ch;
					i++;
				}
				ls.add(key);
				key="";
			}
		}
		System.out.println(ls);
		while(j!=ls.size()) {
			key=ls.get(j);
			if(key.matches("\\d+")) {
				boLanExpression.add(key);
			}else if(key.equals("(")) {
				s1.push(key);
			}else if(key.equals(")")) {
				while(!s1.peek().equals("(")) {
					key=s1.pop();
					boLanExpression.add(key);
				}
				s1.pop();
			}else {
				while(s1.size()!=0 && Operation.IP(key)<=Operation.IP(s1.peek())) {
					boLanExpression.add(s1.pop());
				}
				s1.push(key);
			}
			j++;
		}
		while(s1.size()!=0) {
			boLanExpression.add(s1.pop());
		}
		System.out.println(boLanExpression);
		for(String value:boLanExpression) {
			if(value.matches("\\d+")) {
				s2.push(value);
			}else {
				num1=Integer.parseInt(s2.pop());
				num2=Integer.parseInt(s2.pop());
				if(value.equals("+")) {
					res=num2+num1;
				}else if(value.equals("-")) {
					res=num2-num1;
				}else if(value.equals("*")) {
					res=num2*num1;
				}else if(value.equals("/")) {
					res=num2/num1;
				}
				s2.push(""+res);
				
			}
		}
		System.out.println(res);
	}
}
class Operation{
	private static int ADD = 1;
	private static int CUT = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	public static int IP(String s) {
		int res;
		switch(s) {
		case "+":res=ADD;
		break;
		case "-":res=CUT;
		break;
		case "*":res=MUL;
		break;
		case "/":res=DIV;
		break;
		default:System.out.println("�޴������");
		res=-1;
		break;
		}
		return res;
	}
}