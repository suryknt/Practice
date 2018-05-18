package Train;

import java.util.Scanner;

public class EditDistance {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int p=sc.nextInt();
			int q=sc.nextInt();
			sc.nextLine();
			String[] str=sc.nextLine().split(" ");
			char[] str1=str[0].toCharArray();
			char[] str2=str[1].toCharArray();
			int[][] dp=new int[p+1][q+1];
			for(int i=0;i<=p;i++) {
				for(int j=0;j<=q;j++) {
					if(i==0)dp[i][j]=j;
					else if(j==0)dp[i][j]=i;
					else {
						if(str1[i-1]==str2[j-1])dp[i][j]=dp[i-1][j-1];
						else dp[i][j]=Math.min(1+dp[i-1][j-1], Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
					}
//					System.out.println("i::: "+i+"  j:::: "+j+" dp::: "+dp[i][j]);
				}
				
			}
			System.out.println(dp[p][q]);
		}
	}
}
