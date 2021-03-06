package challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DigitCount {
	static long[] cal=new long[38];
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int t=fr.nextInt();
		
		cal[0]=1;
		for(int i=1;i<38;i++) {
			cal[i]=cal[i-1]*3+1;
			System.out.println(cal[i]);
		}
		while (t-->0) {
			int n=fr.nextInt();
			int val=binarySearch(n,0,37)+1;
			System.out.println(val);
			
		}
	}
	
	private static int binarySearch(int n, int start, int end) {
		if(start==end)return start;
		int mid= start+((end-start)/2);
		if(n>=cal[mid] && n<cal[mid+1])return mid;
		else if(n>=cal[mid]) return binarySearch(n, mid+1, end);
		else return binarySearch(n, start, mid-1);
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
			String str="";
			try {
				str= br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
		}
		
	}
}
