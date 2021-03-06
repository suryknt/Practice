package challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringCompare {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int n=fr.nextInt();
		int q=fr.nextInt();
		char[] str1=fr.nextLine().toCharArray();
		char[] str2=fr.nextLine().toCharArray();
		long num1=getValue(str1, n);
		long num2=getValue(str2, n);
		
		while(q-->0) {
			int querry=n-fr.nextInt();
			num2 |= (1<<querry);
			String v="NO";
//			System.out.println("num1::: "+num1+"  num2::"+num2);
			if(num2>=num1)v="YES";
			System.out.println(v);
		}
//		System.out.println(getValue(str1,n));
		
	}
	static public long getValue(char[] a, int n) {
		long ret=0L;
		int i=n-1;
		int count=0;
		while(i>=0) {
			ret+=Math.pow(2, count)*Character.getNumericValue(a[i]);
			count++;
			i--;
		}
		return ret;
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
