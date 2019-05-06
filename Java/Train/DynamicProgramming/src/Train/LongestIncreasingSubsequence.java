package Train;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n];
		int[] a=new int[n];
		int globalMax=0;
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
			int max=0;
			for(int j=0;j<i;j++)if(a[i]>a[j])max=Math.max(max, dp[j]);		
			dp[i]=max+1;
			globalMax=Math.max(globalMax, dp[i]);
		}
//		printArray(dp);
		System.out.println(globalMax);
		sc.close();
		
	}
static int longestIncreasingSubsequence(int[] arr) {
        
		int n=arr.length;
		int[] dp=new int[n];
        int globalMax=0;
		for(int i=0;i<n;i++) {
			int max=0;
			for(int j=0;j<i;j++)if(arr[i]>arr[j])max=Math.max(max, dp[j]);		
			dp[i]=max+1;
            globalMax=Math.max(globalMax,dp[i]);
		}
        return globalMax;
		
	
    }
	public static void printArray(int[] a) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) System.out.println(a[i]+" ");
		System.out.println("]");
	}
}
