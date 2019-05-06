package Train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Powerset {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int n=fr.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=fr.nextInt();
		}
		double s=Math.pow(2, n);
		
		for(int i=0;i<s;i++) {
			Set<Integer> set=new HashSet<Integer>();
			int t=i;
			int count=0;
			while(t !=0) {
				
				if((t&1)==1) {
					set.add(arr[count]);	
				}
				count++;
				t=t>>1;
			}
			System.out.println(set.toString());
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
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
		
		String nextLine() {
			String str="";
			try {
				 str=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
