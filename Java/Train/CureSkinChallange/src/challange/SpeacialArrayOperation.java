package challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SpeacialArrayOperation {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int n=fr.nextInt();
		int q=fr.nextInt();
		long sum=0;
		TreeSet<Integer> ts=new TreeSet<Integer>();
		for(int i=0;i<n;i++) {
			int e=fr.nextInt();
			ts.add(e);
			sum+=e;
			System.out.println("i::: "+i+" ts:: --> "+ts.size());
		}
		System.out.println(ts.size());
		long[] dp=new long[n];
		dp[0]=sum;
		for(int i=1;i<n;i++) {
			if(ts.size()>=2) {
				int largest=ts.pollLast();
				int smallest=ts.pollFirst();
				sum-=smallest<<1;
				ts.add(largest-smallest);
//				System.out.println("i:: "+i+" ts:: "+ts.size());
				dp[i]=sum;
			}else {
				dp[i]=0;
			}
		}
		for(int i=0;i<q;i++) {
			int k=fr.nextInt();
			System.out.println(dp[k]);
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
		String nextLine() {
			String ret="";
			try {
				ret=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ret;
		}
		
		
	}
}
