package hfmtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HfmZip {
	static HashMap<Byte,String> HfmZipCode = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="i like like like java do you like a java";
		byte[] b = HfmZip(msg);
		System.out.println(UnZip(decode(b)));
		System.out.println(Integer.parseInt("11010000",2)); //8
		//System.out.println(Integer.toString(|256,2)); //1010
		//System.out.println(13|256);
	}
	private static List<Node2> getList(String s) {
		byte[] answer = s.getBytes();
		Map<Byte,Integer> code = new HashMap<>();
		for(byte b:answer) {
			Integer count = code.get(b);
			if(count==null) {
				code.put(b, 1);
			}else {
				code.put(b, count+1);
			}
		}
		List<Node2> list = new ArrayList<>();
		for(Map.Entry<Byte, Integer> entry:code.entrySet()) {
			list.add(new Node2(entry.getKey(),entry.getValue()));
		}
		return list;
	}
	private static Node2 createTree(List<Node2> list) {
		while(list.size()>1) {
			Collections.sort(list);
			Node2 leftNode = list.get(0);
			Node2 rightNode = list.get(1);
			Node2 parent = new Node2(null,leftNode.weight+leftNode.weight);
			parent.left=leftNode;
			parent.right=rightNode;
			list.remove(leftNode);
			list.remove(rightNode);
			list.add(parent);
		}
		return list.get(0);
	}
	private static void getCode(Node2 node,String code,StringBuffer strBuf) {
		StringBuffer strBuf2 = new StringBuffer(strBuf);
		strBuf2.append(code);
		if(node!=null) {
			if(node.data==null) {
				getCode(node.left,"0",strBuf2);
				getCode(node.right,"1",strBuf2);
			}else {
				HfmZipCode.put(node.data, strBuf2.toString());
			}
		}
	}
	private static byte[] getNumber(byte[] bytes) {
		StringBuffer strBuf = new StringBuffer();
		for(byte b:bytes) {
			strBuf.append(HfmZipCode.get(b));
		}
		System.out.println(strBuf.toString());
		int len;
		len=(strBuf.length()+7)/8;
		byte[] b = new byte[len];
		int index = 0;
		for(int i=0;i<strBuf.length();i+=8) {
			String s;
			if(i+8>strBuf.length()) {
				s = strBuf.substring(i);
			}else {
				s = strBuf.substring(i,i+8);
			}
			b[index++] = (byte)Integer.parseInt(s, 2);
		}
		System.out.println(Arrays.toString(b));
		return b;
	}
	public static byte[] HfmZip(String s) {
		List<Node2> nodes = getList(s);
		Node2 root = createTree(nodes);
		getCode(root,"",new StringBuffer());
		return getNumber(s.getBytes());
	}
	private static String decode(byte[] bytes) {
		StringBuffer strBuf = new StringBuffer();
		for(int i = 0;i<bytes.length;i++) {
			int temp = bytes[i];
			String s;
			if(i==bytes.length-1) {
				s=Integer.toBinaryString(temp);
			}else {
				//System.out.println(temp);
				temp|=256;
				
				String st=Integer.toBinaryString(temp);
				s=st.substring(st.length()-8);
			}
			strBuf.append(s);
		}
		return strBuf.toString();
	}
	public static String UnZip(String s) {
		System.out.println(s);
		int count = 0;
		int i = 0;
		boolean flag = true;
		StringBuffer strBuf = new StringBuffer();
		Map<String,Byte> UnHfmZipCode =new HashMap<>();
		for(Map.Entry<Byte, String> entry:HfmZipCode.entrySet()) {
			UnHfmZipCode.put(entry.getValue(), entry.getKey());
		}
		while(flag && count<s.length()) {
			Byte a;
			if(count+i<=s.length()) {
				a = UnHfmZipCode.get(s.substring(count,count+i));
			}else {
				a = UnHfmZipCode.get(s.substring(count));
				flag=false;
			}
			if(a!=null) {
				int temp = a;
				strBuf.append((char)temp);
				count+=i;
				i=0;
			}else {
				i++;
			}
		}
		return strBuf.toString();
	}
}
class Node2 implements Comparable<Node2>{
	Byte data;
	int weight;
	Node2 left;
	Node2 right;
	public Node2(Byte b,int n) {
		this.data = b;
		this.weight = n;
	}
	@Override
	public int compareTo(Node2 o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	public String toString() {
		return "date:"+this.data+"weight:"+this.weight;
	}
}