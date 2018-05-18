
public class SimpleBinarySearch {
	public static void main(String[] args) {
		int[] a= {4,7,12,19,23,34,54,76};
		int ind=binarySearch(a,10);
		if(ind<0)System.out.println("Element not found");
		else System.out.println("Element found at index "+ind);
	}

	private static int binarySearch(int[] a, int num) {
		int low=0;
		int high=a.length-1;
		int mid=low+(high-low)/2;
		while(low<=high) {
			mid=low+(high-low)/2;
			if(a[mid]==num)return mid;
			else if(a[mid]<num)low=mid+1;
			else high=mid-1;
		}
		return -1;
	}
}
