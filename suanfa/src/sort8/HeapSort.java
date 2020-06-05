package sort8;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tree = {4,10,3,5,1,2,6,7,8,9};
		heap_sort(tree);
		System.out.println(Arrays.toString(tree));
	}
	public static void heap_sort(int[] tree) {
		build_tree(tree);
		for(int i = tree.length - 1;i >= 0;i--) {
			swap(tree,i,0);
			heapify(tree,i,0);
		}
	}
	private static void build_tree(int[] tree) {
		int last_node = tree.length - 1;
		int par = (last_node - 1) / 2;
		for(int i = par;i >= 0;i--) {
			heapify(tree,tree.length,i);
		}
	}
	private static void heapify(int[] tree,int n,int i) {
		if(i >= n) return;
		int c1 = 2 * i + 1;
		int c2 = 2 * i + 2;
		int max = i;
		if(c1 < n && tree[c1] > tree[max]) max = c1;
		if(c2 < n && tree[c2] > tree[max]) max = c2;
		if(max != i) {
			swap(tree,i,max);
			heapify(tree,n,max);
		}
	}
	public static void swap(int[] arr,int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
//	public static void heap_sort(int[] tree,int n) {
//		build_heap(tree,n);
//		int i;
//		for(i = n - 1;i >= 0;i--) {
//			swap(tree, i ,0);
//			heapify(tree,i,0);
//		}
//	}
//	private static void build_heap(int[] tree,int n) {
//		int last_node = n - 1;
//		int par = (last_node - 1) / 2;
//		for(int i = par;i >= 0;i--) {
//			heapify(tree,n,i);
//		}
//	}
//	private static void heapify(int[] tree,int n,int i) {
//		if(i >= n) return ;
//		int c1 = 2 * i + 1;
//		int c2 = 2 * i + 2;
//		int max = i;
//		if(c1 < n && tree[c1] > tree[max]) max = c1;
//		if(c2 < n &&tree[c2] > tree[max]) max = c2;
//		if(max != i) {
//			swap(tree,i,max);
//			heapify(tree,n,max);
//		}
//	}
//	private static void swap(int[] tree,int i,int j) {
//		int temp = tree[i];
//		tree[i] = tree[j];
//		tree[j] = temp;
//	}
//	public static void heaoSort(int[] arr) {
//		System.out.println("������!!");
//		int temp;
//		for(int i=arr.length/2-1;i>=0;i--) {
//			adjustHeap(arr,1,arr.length);
//		}
//		for(int j =arr.length-1;j>0;j--) {
//			temp=arr[j];
//			arr[j]=arr[0];
//			arr[0]=temp;
//			adjustHeap(arr,0,j);
//		}
//		System.out.println(Arrays.toString(arr));
//	}
//	public static void adjustHeap(int[] arr,int i,int length) {
//		int temp=arr[i];
//		for(int k=2*i+1;k<length;k=k*2+1) {
//			if(k+1<length && arr[k]<arr[k+1]) {
//				k++;
//			}
//			if(arr[k]>temp) {
//				arr[i]=arr[k];
//				i=k;
//			}else {
//				break;
//			}
//		}
//		arr[i]=temp;
//	}
}
//public static void heap_sort(int[] tree) {
//	build_tree(tree);
//	for(int i = tree.length - 1;i >= 0;i-- ) {
//		swap(tree,i,0);
//		heapify(tree,i,0);
//	}
//}
//public static void build_tree(int[] tree) {
//	int last_node = tree.length - 1;
//	int par = (last_node - 1) / 2;
//	for(int i = par;i >= 0 ;i--) {
//		heapify(tree,tree.length,i);
//	}
//}
//public static void heapify(int[] tree,int n ,int i ) {
//	int c1 = 2 * i + 1;
//	int c2 = 2 * i + 2;
//	int max = i;
//	if(c1 < n && tree[c1] > tree[max]) max = c1;
//	if(c2 < n && tree[c2] > tree[max]) max = c2;
//	if(max != i) {
//		swap(tree,i,max);
//		heapify(tree,n,max);
//	}
//}
//public static void swap(int[] arr,int i ,int j) {
//	int temp = arr[i];
//	arr[i] = arr[j];
//	arr[j] = temp;
//}
