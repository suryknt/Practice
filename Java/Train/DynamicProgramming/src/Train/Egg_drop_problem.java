package Train;

import java.util.Scanner;

public class Egg_drop_problem {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int k=sc.nextInt();
			int[][] dp=new int[n+1][k+1];
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=k;j++) {
					if(j==0 || i==0)dp[i][j]=0;
					else if(i==1) dp[i][j]=j;
					else {
						int min=Integer.MAX_VALUE;
						for(int x=1;x<=j;x++) {
							int egg_break=dp[i-1][x-1];
							int egg_not_break=dp[i][j-x];
							min=Math.min(min, Math.max(egg_break, egg_not_break)+1);
						}
						dp[i][j]=min;
//						System.out.println("i::: "+i+"  j::: "+j+"  dp::: "+min);
					}
					
				}
			}
			System.out.println(dp[n][k]);
		}
	}
}
