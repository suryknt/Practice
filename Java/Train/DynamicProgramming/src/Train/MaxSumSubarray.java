package Train;

import java.util.Scanner;

public class MaxSumSubarray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[] dp=new int[n];
			int max=Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				int num=sc.nextInt();
				if(i==0)dp[i]=num;
				else dp[i]=Math.max(num, num+dp[i-1]);
				max=Math.max(max, dp[i]);
			}
			System.out.println(max);
		}
	}
}
