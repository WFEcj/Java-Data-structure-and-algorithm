package sort8;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,6,5,0,1,7,4};
		MergeSort.mergeSort(arr, 0, arr.length-1);
		System.out.print(Arrays.toString(arr));
	}
	public static void mergeSort(int[] arr,int l,int r) {
		if(l == r) return;
		else {
			int mid = (l + r) /2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid + 1,r);
			merge(arr,l,mid + 1,r);
		}
	}
	public static void merge(int[] arr,int l,int mid,int r) {
		int left_size = mid - l;
		int right_size = r - mid + 1;
		int[] left = new int[left_size];
		int[] right = new int[right_size];
		int i,j,k;
		for(i = l;i < mid;i++) {
			left[i - l] = arr[i];
		}
		for(i = mid;i <= r;i++) {
			right[i - mid] = arr[i];
		}
		i = 0;j = 0;k = 0;
		while(i < left_size && j < right_size) {
			if(left[i] < right[j]) arr[k++] = left[i++];
			else arr[k++] = right[j++];
		}
		while(i < left_size) {
			arr[k++] = left[i++];
		}
		while(j < right_size) {
			arr[k++] = right[j++];
		}
	}
}
//public static void merge(int[] arr,int left,int right,int[] temp) {
//	if(left<right) {
//		int mid=(left+right)/2;
//		merge(arr,left,mid,temp);
//		merge(arr, mid+1, right, temp);
//		mergeSort(arr, left, right, temp);
//	}
//}
//public static void mergeSort(int[] arr,int left,int right,int[] temp) {
//	int l=left;
//	int mid=(left+right)/2;
//	int r=mid+1;
//	int t=0;
//	while(l<=mid && r<=right) {
//		if(arr[l]<=arr[r]) {
//			temp[t]=arr[l];
//			t++;
//			l++;
//		}else {
//			temp[t]=arr[r];
//			t++;
//			r++;
//		}
//	}
//	while(l<=mid) {
//		temp[t]=arr[l];
//		t++;
//		l++;
//	}
//	while(r<=right) {
//		temp[t]=arr[r];
//		t++;
//		r++;
//	}
//	t=0;
//	int templeft=left;
//	while(templeft<=right) {
//		arr[templeft]=temp[t];
//		t++;
//		templeft++;
//	}
//}
