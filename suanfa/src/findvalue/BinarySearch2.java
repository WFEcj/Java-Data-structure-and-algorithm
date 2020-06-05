package findvalue;

public class BinarySearch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,2,3,4,5,6};
		System.out.println(find_value(arr,5));
	}
	private static int find_value(int[] arr, int val) {
		int index = -1;
		int low = 0,high = arr.length - 1,mid = 0;
		while(low <= high) {
			mid = low + (high - low)/2;
			if(val > arr[mid]) {
				low = mid + 1;
			} else if(val < arr[mid]) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return index;
	}
}
