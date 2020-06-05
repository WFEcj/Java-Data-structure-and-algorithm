package test;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Queue<String> queue = new LinkedList<>();
		Stack<BigInteger> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		Integer radix = 10;
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i < n; i++) {
			String s = in.nextLine();
			queue.offer(s);
		}
//		//System.out.print(queue.toString());
		//s1.push(new BigInteger(queue.poll()));
		
		while(!queue.isEmpty()) {
			String[] op = queue.poll().split(" ");
			switch(op[0]) {
			case "CLEAR":
				s1.clear();
				s2.clear();
				//s1.push(BigInteger.ZERO);
				break;
			case "CHANGE":
				radix = Integer.parseInt(op[1]);
				break;
			case "NUM":
				if(!s1.isEmpty() && s1.peek() == BigInteger.ZERO && s2.isEmpty()) {
					s1.pop();
				}
				if(s2.isEmpty() || s1.size()!=2) {
					s1.push(new BigInteger(op[1],radix));
				}
				if(!s2.isEmpty() && s1.size() == 2){
					BigInteger num1 = s1.pop();
					BigInteger num2 = s1.pop();
					char gz = s2.pop();
					BigInteger res = cul(gz,num1,num2);
					s1.push(res);
				}
				break;
			case "ADD":
				s2.push('+');
				break;
			case "SUB":
				s2.push('-');
				break;
			case "MUL":
				s2.push('*');
				break;
			case "DIV":
				s2.push('/');
				break;
			case "MOD":
				s2.push('%');
				break;
			case "EQUAL":
				System.out.println(s1.peek().toString(radix).toUpperCase());
			default:
//				System.out.println("输入有误!");
				break;
			}
		}
		
	}
	private static BigInteger cul(char op,BigInteger num1,BigInteger num2) {
		BigInteger res = null;
		switch(op) {
		case '+': res = num2.add(num1);
		break;
		case '-': res = num2.subtract(num1);
		break;
		case '*': res = num2.multiply(num1);
		break;
		case '/': res = num2.divide(num1);
		break;
		case '%': res = num2.mod(num1);
		break;
		default:System.out.print("1");
		break;
		}
		return res;
	}
}
