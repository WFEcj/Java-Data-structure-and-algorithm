package findvalue;

import java.util.Arrays;

public class FibonacciSearch2 {
	private static int MAXSIZE = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,5,6,8,9};
		System.out.println(find_value(arr,1));
	}
	private static int[] getFiBoArr() {
		int[] arr = new int[MAXSIZE];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2;i < MAXSIZE;i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr;
	}
	public static int find_value(int[] arr,int val) {
		int low = 0,high = arr.length - 1,k = 0,mid = 0;
		int[] f = getFiBoArr();
		while(high > f[k] - 1) {
			k++;
		}
		int[] temp = Arrays.copyOf(arr, f[k] - 1);
		for(int i = arr.length;i < temp.length;i++) {
			temp[i] = arr[high];
		}
		while(low <= high) {
			mid = low + f[k - 1] - 1;
			if(temp[mid] < val) {
				low = mid + 1;
				k -= 2;
			} else if(temp[mid] > val) {
				high = mid - 1;
				k--;
			} else {
				if(mid >= arr.length) {
					return arr.length - 1;
				} else {
					return mid;
				}
			}
		}
		return -1;
	}
}
