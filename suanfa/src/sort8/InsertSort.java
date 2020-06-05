package sort8;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] array = {5,9,6,4,2,8};
		int num = 0;
		for(int i = 1;i < array.length;i++) {
			num = array[i];
			int j = i;
			if(array[j - 1] > num) {
				while(j - 1 >= 0 && array[j - 1] > num) {
					array[j] = array[j - 1];
					j -= 1;
				}
				array[j] = num;
			}
			
		}
		System.out.println(Arrays.toString(array));
	}
}
//int num;
//for(int i=1;i<array.length;i++) {
//	num=array[i];
//	int j=i-1;
//	while(j>=0 && array[j]>num) {
//		int tempt = num;
//		array[j+1]=array[j];
//		array[j]=tempt;
//		j=j-1;
//	}
//}
//for(int value:array) {
//	System.out.print(value);
//}
//int num;
//for(int i = 1; i < array.length;i++) {
//	num = array[i];
//	int j = i - 1;
//	while(j >= 0 && array[j] > num) {
//		array[j + 1] = array[j];
//		array[j] = num;
//		j -= 1;
//	}
//	
//}