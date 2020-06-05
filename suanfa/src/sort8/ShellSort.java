package sort8;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,8,9,4,3,6,7,1,0,2,2,43,5,7,0,1231};
		int count = 0;
		int num = 0;
		for(int i = array.length;i > 0;i /= 2) {
			for(int j = i;j < array.length;j++) {
				num = array[j];
				count = j;
				if(array[count - i] > num) {
					while(count - i >= 0 && array[count - i] > num) {
						array[count] = array[count - i];
						count -= i;
					}
					array[count] = num;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
//for(int i=array.length/2;i>0;i/=2) {
//	for(int j=i;j<array.length;j++) {
//		count=j;
//		min=array[count];
//		if(array[j-i]>min) {
//			while(count-i>=0 && array[count-i]>min) {
//				array[count]=array[count-i];
//				count-=i;
//			}
//			array[count]=min;
//		}
//	}
//}
//for(int i = array.length/2;i > 0; i /= 2) {
//	for(int j = i;j < array.length; j++) {
//		count = j;
//		min = array[j]; 
//		if(array[count - i] > min) {
//			while(count - i >= 0 && array[count - i] > min) {
//				array[count] = array[count - i];
//				count -= i;
//			}
//			array[count] = min;
//		}
//	}
//}
