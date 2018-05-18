package Train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Unbound_knapsack_0_1 {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t=fr.nextInt();
		while(t-->0) {
			
			int n=fr.nextInt();
			int capacity=fr.nextInt();
			int[] weights =new int[n];
			int[] values= new int[n];
			int[][] dp=new int[capacity+1][n+1];
			//we either choose the item or dont, we calculate values for both cases and pick the max
			for(int i=0;i<n;i++) {
				weights[i]=fr.nextInt();
				values[i]=weights[i]; //fr.nextInt(); in this question weights and values are same
			}
			
			for(int i=0;i<=capacity;i++) {
				for(int j=0;j<=n;j++) {
					if(i==0 || j==0)dp[i][j]=0;
					else{
						int with_current_item=0;
						int k=capacity/weights[j-1];
						for(int s=1;s<=k;s++) {
							with_current_item=Math.max(with_current_item, i-(s*weights[j-1])>=0?s*values[j-1]+dp[i-(s*weights[j-1])][j-1]:0);
						}
						dp[i][j]=Math.max(dp[i][j-1], with_current_item);
//						System.out.println("i::: "+i+"  j::: "+j+" dp::: "+dp[i][j]);
					};
//					if(i==capacity && dp[i][j]==capacity)break;
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
