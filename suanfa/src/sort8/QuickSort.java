package sort8;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,6,5,0,1,7,4};
		QuickSort.QuickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void QuickSort(int[] arr,int left,int right) {
		int l = left,r = right,mid = arr[(l + r)/2];
		while(r > l) {
			while(arr[l] < mid) l++;
			while(arr[r] > mid) r--;
			if(l >= r) break;
			swap(arr,l,r);
			if(arr[l] == mid) l++;
			if(arr[r] == mid) r--;
		}
		if(l == r) {
			l++;
			r--;
		}
		if(left < r) QuickSort(arr,left,r);
		if(right > l) QuickSort(arr,l,right);
	}
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
//int l = left;
//int r = right;
//int temp = 0;
//int mid = arr[(left + right)/2];
//while(l<r) {
//	while(arr[l]<mid) {
//		l++;
//	}
//	while(arr[r]>mid) {
//		r--;
//	}
//	if(l>=r) {
//		break;
//	}
//	temp = arr[r];
//	arr[r] = arr[l];
//	arr[l] = temp;
//	if(arr[l]==mid) {
//		r--;
//	}
//	if(arr[r]==mid) {
//		l++;
//	}
//}
//if(l==r) {
//	l++;
//	r--;
//}
//if(left<r) {
//	QuickSort(arr,left,r);
//}
//if(l<right) {
//	QuickSort(arr,l,right);
//}