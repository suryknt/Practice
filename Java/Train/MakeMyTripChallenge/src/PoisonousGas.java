import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PoisonousGas {
	public static void main(String[] args) {
        
		FastReader fr=new FastReader();
		int t=fr.nextInt();
		while(t-->0) {
			int n=fr.nextInt();
			double strength=0;
			for(int i=0;i<n;i++) {
				long s=fr.nextLong();
				strength+=s>0?s:0;
			}
			String res="No";
			if(strength>0 && strength%2==0) {
				double v=Math.log(strength)/Math.log(2);
				if(v-Math.floor(v)==0)res="Yes";
			}
			if(strength==1)res="yes";
			System.out.println(res);
		}
		
//		double n=Math.log(Math.pow(2, 18)+1)/Math.log(2);
//		System.out.println(n);
//		System.out.println(Math.floor(n));
//		System.out.println(n-Math.floor(n)==0);
//		
//		
	
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
