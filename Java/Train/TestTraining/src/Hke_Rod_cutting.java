import java.util.Scanner;

public class Hke_Rod_cutting {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		int maxSize=(int) (Math.log(1000000001)/Math.log(2));
//		System.out.println("maxSize:: "+maxSize);
		int[] dp=new int[maxSize];
		dp[0]=1;
		for(int i=1;i<maxSize;i++)dp[i]=2*dp[i-1]+1;
//		printArray(dp);
		while(t-->0) {
			int n=sc.nextInt();
			int i=binarySerach(dp,n,0,maxSize-1);
			System.out.println(i);
		}
	}
	private static int binarySerach(int[] dp, int i, int start, int end) {
		int mid=start+(end-start)/2;
//		System.out.println("start:: "+start+" end:: "+end+" mid::: "+mid+" dp[mid]:: "+dp[mid]);
		if(start==end || dp[mid]<=i && dp[mid+1]>i) return mid;
		else if(dp[mid]>i) return binarySerach(dp, i, start, mid);
		else return binarySerach(dp, i, mid+1, end);
	}
	public static void printArray(int[] a) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println("]");
	}
}
