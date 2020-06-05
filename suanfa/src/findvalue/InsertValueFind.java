package findvalue;

public class InsertValueFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static int insertValueFind(int[] arr,int left,int right,int findValue) {
		if(left > right || findValue<arr[0] || findValue>arr[arr.length-1]) {
			return -1;
		}
		int mid = left + (right - left)*(findValue - arr[left])/(arr[right]-arr[left]);
		if(findValue>arr[mid]) {
			return InsertValueFind.insertValueFind(arr, mid+1, right, findValue);
		}else if(findValue<arr[mid]) {
			return InsertValueFind.insertValueFind(arr, left, mid-1, findValue);
		}else {
			return mid;
		}
	}
}
