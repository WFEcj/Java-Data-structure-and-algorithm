package kpm;

public class bf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "abcdrfg";
		String str = "drf";
		System.out.println(index(msg,0,str));
	}
	private static int index(String s,int pos,String t) {
		int i = pos,j = 0;
		int sl = s.length(),tl = t.length();
		while(i<sl && j<tl) {
			if(s.charAt(i)==t.charAt(j)) {
				i++;
				j++;
			}else {
				i = i-j+1;
				j = 0;
			}
		}
		if(j==tl) {
			return i - tl;
		}else {
			return -1;
		}
	}
}
