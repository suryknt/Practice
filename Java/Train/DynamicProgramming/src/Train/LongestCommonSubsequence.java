package Train;

import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int s1=sc.nextInt();
			int s2=sc.nextInt();
			sc.nextLine();
			char[] str1=sc.nextLine().toCharArray();
			char[] str2=sc.nextLine().toCharArray();
			int[][] dp=new int[s1+1][s2+1];
			
			for(int i=0;i<=s1;i++) {
				for(int j=0;j<=s2;j++) {
					if(i==0 || j==0)dp[i][j]=0;
					else {
						
						dp[i][j]=str1[i-1]==str2[j-1]?
								1+dp[i-1][j-1]:
									Math.max(dp[i-1][j], dp[i][j-1]);
//						System.out.println("i::: "+i+"  j::: "+j+"  dp::: "+dp[i][j]);
					}
				}
			}
			System.out.println(dp[s1][s2]);
			
		}
	}
}
