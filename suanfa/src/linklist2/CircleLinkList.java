package linklist2;

public class CircleLinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[5];
		for(int i =0;i<a.length;i++) {
			a[i] = i+1;
		}
		int outNumber = 0;
		int index = 0;
		int count = 0;
		int n = 2;
		while(outNumber!=5) {
			if(a[index]!=0) {
				count++;
				if(count==n) {
					n=a[index];
					a[index]=0;
					count=0;
					outNumber++;
					System.out.println(index+1);
				}
			}
			index++;
			if(index==5) {
				index=0;
			}
		}
	}
}