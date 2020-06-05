package findvalue;

import java.util.Arrays;

public class FibonacciSearch {
	public static int MAXSIZE = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,5,6,8,9};
		int index = FibonacciSearch.fibonacciSearch(arr, 5);
		System.out.println(index);
	}
	public static int[] fib() {
		int[] f = new int[MAXSIZE];
		f[0]=0;
		f[1]=1;
		for(int i =2;i<MAXSIZE;i++) {
			f[i]=f[i-1]+f[i-2];
		}
		return f;
	}
	public static int fibonacciSearch(int[] arr,int findValue) {
		int left=0;
		int k = 0;
		int right = arr.length-1;
		int[] fib=FibonacciSearch.fib();
		while(right>fib[k]-1) {
			k++;
		}
		int[] f = Arrays.copyOf(arr, fib[k] - 1);
		for(int i=arr.length;i<f.length;i++) {
			f[i]=arr[right];
		}
		while(left<=right) {
			int mid = left + fib[k-1]-1;
			if(findValue>f[mid]) {
				left=mid+1;
				k-=2;
			}else if(findValue<f[mid]) {
				right=mid-1;
				k--;
			}else {
				if(mid<=arr.length-1) {
					return mid;
				}
				if(mid>=arr.length-1) {
					return arr.length-1;
				}
			}
		}
		return -1;
	}
}
