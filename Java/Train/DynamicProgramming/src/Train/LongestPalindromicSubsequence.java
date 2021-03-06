package Train;

import java.util.Scanner;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			char[] s=sc.nextLine().toCharArray();
			int n=s.length;
			int[][] dp=new int[n][n];
			boolean[][] dpStatus=new boolean[n][n];
			int maxLength=getLps(s,0,n-1,dp,dpStatus);
			System.out.println(maxLength);
		}
		sc.close();
	}

	private static int getLps(char[] s, int i, int j, int[][] dp, boolean[][] dpStatus) {
		if(dpStatus[i][j])return dp[i][j];
		if(j<i) {
			dp[i][j]=0;
			dpStatus[i][j]=true;
			return 0;
		}
		if(i==j) {
			dp[i][j]=1;
			dpStatus[i][j]=true;
			return 1;
		}
		if(s[i]==s[j]) {
			dp[i][j]=2+getLps(s, i+1, j-1, dp, dpStatus);
			dpStatus[i][j]=true;
			return dp[i][j];
		}
		
		int ret=Math.max(getLps(s, i+1, j, dp, dpStatus), getLps(s, i, j-1, dp, dpStatus));
		dp[i][j]=ret;
		dpStatus[i][j]=true;
		return ret;
	}
}
