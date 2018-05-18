package Train;

import java.util.Scanner;

public class CoinChangeProblem {
//	public static int[][] dp=new int[300][300];
//	public static boolean[][] dpDone=new boolean[300][300];
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			
			int m=sc.nextInt();
			int[] coins=new int[m+1];
			for(int i=1;i<=m;i++) {
				coins[i]=sc.nextInt();
			}
			int n=sc.nextInt();
			long[][] dp=new long[m+1][n+1];
			boolean[][] dpDone=new boolean[m+1][n+1];
			for(int i=0;i<=n;i++) {
				dpDone[0][i]=true;
				dpDone[1][i]=true;
				dp[1][i]=i==0 ||(i>=coins[1] && i%coins[1]==0)?1:0;
//				System.out.println("i:: "+0+" j:: "+i+" dp[i][j]::"+dp[0][i]);
//				System.out.println("i:: "+1+" j:: "+i+" dp[i][j]::"+dp[1][i]);
//				System.out.println("-------------------------------------------------0");

			}
			for(int i=2;i<=m;i++) {
				for(int j=0;j<=n;j++) {
					if(!dpDone[i][j]) {
						long withoutcoini=dp[i-1][j];
//						System.out.println("j:: "+j+" coins[j]:: "+coins[j]);
						long withatleast1coini=(j-coins[i]>0)?dp[i][j-coins[i]]:j-coins[i]==0?1:0;
						dp[i][j]=withoutcoini+withatleast1coini;
//						System.out.println("i:: "+i+" j:: "+j+" dp[i][j]::"+dp[i][j]);
						dpDone[i][j]=true;
					}
					
				}
			}
			System.out.println(dp[m][n]);
			
		}
		sc.close();
	}
}
