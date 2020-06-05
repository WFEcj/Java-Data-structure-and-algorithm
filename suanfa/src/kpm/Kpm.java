package kpm;

import java.util.Arrays;
import java.util.List;

public class Kpm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaabaaaa";
		String str = "abc";
		int[] n = kpmNext(s);
		System.out.println(s);
		System.out.println(Arrays.toString(n));
		int index = getIndex(s,0,str,n);
		System.out.println(index);
	}
	public static int getIndex(String str1,int pos,String str2,int[] next) {
		for(int i = pos,j = 0;i<str1.length();i++) {
			while(j>0 && str1.charAt(i)!=str2.charAt(j)) {
				j = next[j-1];
			}
			if(str1.charAt(i)==str2.charAt(j)) {
				j++;
			}
			if(j==str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}
	public static int[] kpmNext(String s) {
		int[] next = new int[s.length()];
		next[0] = 0;
		for(int i=1,j=0;i<s.length();i++) {
			while(j>0 && s.charAt(i)!=s.charAt(j)) {
				j=next[j-1];
			}
			if(s.charAt(i)==s.charAt(j)) {
				j++;
			}
			next[i]=j;
		}
		return next;
	}
}
