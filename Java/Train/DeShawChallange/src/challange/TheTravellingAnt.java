package challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Dynamic Programming and Matrix exponentiation
public class TheTravellingAnt {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int t=fr.nextInt();
		int maxPow=60;
		int[][][] dp=new int[maxPow][5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				int k=j-1==-1?4:j-1;
				int p=j+1==5?0:j+1;
				if(i==k || i==p)dp[0][i][j]=1;
			}
		}
		for(int i=0; i<=maxPow;i++) {
			
		}
		while(t-->0) {
			
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
		long nextLong() {
			return Long.parseLong(next());
		}
		
		
	}
}
