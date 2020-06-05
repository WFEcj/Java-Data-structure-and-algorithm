package sort8;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,9,6,5,8,2};
		for(int i = 0;i < array.length - 1;i++) {
			int min = i;
			for(int j = i + 1;j < array.length;j++) {
				if(array[min] > array[j]) min = j;
			}
			if(min != i) swap(array,min,i);
		}
		System.out.println(Arrays.toString(array));
	}
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
//for(int i=0;i<array.length-1;i++) {
//	int min = array[i];
//	int count=i;
//	for(int j=i+1;j<array.length;j++) {
//		if(min>array[j]) {
//			count=j;
//			min=array[j];
//		}
//	}
//	array[count]=array[i];
//	array[i]=min;
//}
//for(int i = 0; i < array.length - 1;i++) {
//	int count = i;
//	int min = array[i];
//	for(int j = i + 1;j < array.length;j++) {
//		if(min > array[j]) {
//			count = j;
//			min = array[j];
//		}
//	}
//	array[count] = array[i];
//	array[i] = min;
//}

