package findvalue;

import java.util.ArrayList;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,5,5,5,5,5,5,6,8,9};
		ArrayList<Integer> indexList = new ArrayList<>();
		indexList=BinarySearch.binarySearch(arr, 0, arr.length-1, 5);
		System.out.println(indexList);
	}
	public static ArrayList<Integer> binarySearch(int[] arr,int left,int right,int value) {
		if(left>right) {
			return new ArrayList<Integer>();
		}
		int l=left;
		int r=right;
		int mid=(left+right)/2;
		if(value>arr[mid]) {
			return BinarySearch.binarySearch(arr, mid+1, r, value);
		}else if(value<arr[mid]) {
			return BinarySearch.binarySearch(arr, l, mid-1, value);
		}else{
			ArrayList<Integer> indexList = new ArrayList<>();
			int temp =mid -1;
			while(true) {
				if(temp<0 || arr[temp]!=value) {
					break;
				}
				indexList.add(temp);
				temp-=1;
			}
			indexList.add(mid);
			temp=mid+1;
			while(true) {
				if(temp>right || arr[temp]!=value) {
					break;
				}
				indexList.add(temp);
				temp+=1;
			}
			return indexList;
		}
		
	}
}
