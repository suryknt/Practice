package Train;

import java.util.Scanner;

public class MatrixSum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] dp=new int[n+1][m+1];
		for(int i=1;i<=n;i++)for(int j=1;j<=m;j++)dp[i][j]=dp[i][j-1]+dp[i-1][j]+sc.nextInt()-dp[i-1][j-1];
		int q=sc.nextInt();
		while(q-->0) {
			System.out.println(dp[sc.nextInt()][sc.nextInt()]);
		}
		sc.close();
	}
}
