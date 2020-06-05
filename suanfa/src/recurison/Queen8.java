package recurison;

public class Queen8 {
	public int[] answer = new int[8];
	public int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen8 q = new Queen8();
		q.check(0);
		System.out.println(q.count);
	}
	public boolean indulge(int n) {
		for(int i=0;i<n;i++) {
			if(answer[n]==answer[i] || Math.abs(n-i)==Math.abs(answer[n]-answer[i])) {
				return false;
			}
		}
		return true;
	}
	public void print() {
		for(int i =0;i<8;i++) {
			System.out.print(answer[i]);
		}
		System.out.println();
	}
	public void check(int n) {
		if(n==8) {
			count++;
			print();
			return;
		}
		for(int i=0;i<8;i++) {
			answer[n]=i;
			if(indulge(n)) {
				check(n+1);
			}
		}
	}
}
