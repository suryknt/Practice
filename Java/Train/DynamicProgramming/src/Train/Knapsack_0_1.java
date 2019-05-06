package Train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack_0_1 {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t=fr.nextInt();
		while(t-->0) {
			int capacity=fr.nextInt();
			int n=fr.nextInt();
			int[] weights =new int[n];
			int[] values= new int[n];
			int[][] dp=new int[capacity+1][n+1];
			for(int i=0;i<n;i++) {
				weights[i]=fr.nextInt();
				values[i]=fr.nextInt();
			}
			
			for(int i=0;i<=capacity;i++) {
				for(int j=0;j<=n;j++) {
					if(i==0 || j==0)dp[i][j]=0;
					else dp[i][j]=Math.max(dp[i][j-1], i-weights[j-1]>=0?
							dp[i-weights[j-1]][j-1]+values[j-1]
									:0);
					System.out.println("i::: "+i+"  j::: "+j+"  dp::: "+dp[i][j]);
				}
			}
			System.out.println(dp[capacity][n]);
				
		}
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() {
			while(st==null || !st.hasMoreElements()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
