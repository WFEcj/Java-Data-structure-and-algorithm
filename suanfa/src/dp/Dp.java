package dp;

public class Dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {1,2,5};
//		System.out.print(coinChange(A,11));
		System.out.println(getPath(1,3));
	}
	//[1,2,5]  11  组合最少硬币的个数达到指定价格
	public static int coinChange(int A[],int M) {
		int[] f = new int[M+1];
		f[0] = 0;
		int n =A.length;
		int i,j;
		for(i=1;i<=M;i++) {
			f[i] = Integer.MAX_VALUE;
			for(j=0;j<n;j++) {
				if(i>=A[j] && f[i-A[j]]!=Integer.MAX_VALUE)
				f[i] = Math.min(f[i-A[j]]+1, f[i]);
			}
		}
		if(f[M]==Integer.MAX_VALUE) {
			return -1;
		}
		return f[M];
	}
	//求多少种路径问题
	public static int getPath(int m,int n) {
		int[][] map = new int[m][n];
		int i,j;
		for(i = 0;i<m;i++) {
			for(j = 0;j<n;j++) {
				if(i==0 || j==0) {
					map[i][j]=1;
				}else {
					map[i][j] = map[i-1][j]+map[i][j-1];
				}
			}
		}
		return map[m-1][n-1];
	}
	//存在性问题
	public static boolean canJump(int[] A) {
		int n = A.length;
		boolean[] f = new boolean[n];
		f[0] = true;
		for(int i = 1;i<n;i++) {
			for(int j = 0;j<i;j++) {
				if(f[j] && A[j] + j>=i) {
					f[i] = true;
					break;
				}
			}
		}
		return f[n-1];
	}
}
