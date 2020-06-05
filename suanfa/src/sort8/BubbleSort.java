package sort8;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,-1,9,12,2};
		boolean flag = false;
		for(int i = 0;i < array.length - 1;i++) {
			for(int j = 0;j < array.length - 1 - i;j++) {
				if(array[j] > array[j + 1]) {
					swap(array,j,j + 1);
					flag = true;
				}
			}
			if(!flag) break;
			else flag = false;
		}
		System.out.println(Arrays.toString(array));
	}
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
//boolean flag = false;
//for(int i=0;i<array.length-1;i++) {
//	for(int j=0;j<array.length-1-i;j++) {
//		if(array[j]>array[j+1]) {
//			flag=true;
//			int tempt = array[j+1];
//			array[j+1]=array[j];
//			array[j]=tempt;
//		}
//	}
//	if(!flag) {
//		break;
//	}else {
//		flag=false;
//	}
//}
//boolean flag = false;
//for(int i = 0; i < array.length - 1;i++) {
//	for(int j = 0; j < array.length - 1 - i; j++) {
//		if(array[j] > array[j + 1]) {
//			int temp = array[j];
//			array[j] = array[j + 1];
//			array[j + 1] = temp;
//			flag = true;
//		}
//	}
//	if(!flag) break;
//	else flag = false;
//}