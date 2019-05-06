package Train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RhezoAndProblems_MaxSubArray {
	public static void main(String[] args) {
		FastReader fr =new FastReader();
		int n=fr.nextInt();
//		System.out.println(l);
		int[] arr=new int[n+1];
		arr[0]=0;
		for(int i=1;i<=n;i++)arr[i]=arr[i-1]+fr.nextInt();
//		printArray(arr);
//		int sol=maxScore(arr, 0, n-1);
//		int[] a=sieveEratosthenes(n);
//		List<Integer> l=new ArrayList<Integer>() ;
//		for(int i=0;i<a.length;i++)l.add(a[i]);
//		System.out.println(l.toString());
		
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<=n;i++) {
			if(isPrime(i))dp[i]=arr[i];
			else {
				int p=i-nearestLowPrime(i)-1;
				dp[i]=Math.max(dp[i-1], dp[p]+arr[i]-arr[p+1]);
			}
		}
		System.out.println(dp[n]);
		
	}
	public static int maxScore(int[] arr,int start,int end) {
		int n=end-start+1;
		if(n<=1 || start<0 || end>=arr.length) return 0;
		int globalMax=0,localMax=0;
		

		int l=nearestLowPrime(n);
		for(int i=start;i<end;i++) {
			if(i<l)localMax+=arr[i];
			
		}
		localMax+=maxScore(arr,0,start-2)+maxScore(arr, start+l+1, arr.length-1);
		globalMax=localMax;
		for(int i=start+1;i<=end-l+1;i++) {
			localMax=localMax-arr[i-1]+arr[i+l-1]
					+maxScore(arr,0,i-2)+maxScore(arr, i+l+1, arr.length-1);;
			globalMax=Math.max(globalMax, localMax);
			System.out.println("i:: "+i+" localMax:: "+localMax+" globalMax:: "+globalMax);
		}
		
		return globalMax;
	}
	public static int nearestLowPrime(int n) {
		while(n-->2) {
			if(isPrime(n)) return n;
		}
		return 2;	
	}
	public static boolean isPrime(int n) {
		if(n==1) return false;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	public static int[] sieveEratosthenes(int n) {
        if(n <= 32){
            int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
            for(int i = 0;i < primes.length;i++){
                if(n < primes[i]){
                    return Arrays.copyOf(primes, i);
                }
            }
            return primes;
        }
 
        int u = n + 32;
        double lu = Math.log(u);
        int[] ret = new int[(int) (u / lu + u / lu / lu * 1.5)];
        ret[0] = 2;
        int pos = 1;
 
        int[] isp = new int[(n + 1) / 32 / 2 + 1];
        int sup = (n + 1) / 32 / 2 + 1;
 
        int[] tprimes = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        for(int tp : tprimes){
            ret[pos++] = tp;
            int[] ptn = new int[tp];
            for(int i = (tp - 3) / 2;i < tp << 5;i += tp)
                ptn[i >> 5] |= 1 << (i & 31);
            for(int i = 0;i < tp;i++){
                for(int j = i;j < sup;j += tp)
                    isp[j] |= ptn[i];
            }
        }
 
        // 3,5,7
        // 2x+3=n
        int[] magic = { 0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4,
                13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17, 9, 6, 16, 5, 15, 14 };
        int h = n / 2;
        for(int i = 0;i < sup;i++){
            for(int j = ~isp[i];j != 0;j &= j - 1){
                int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
                int p = 2 * pp + 3;
                if(p > n)
                    break;
                ret[pos++] = p;
                for(int q = pp;q <= h;q += p)
                    isp[q >> 5] |= 1 << (q & 31);
            }
        }
 
        return Arrays.copyOf(ret, pos);
    }
	public static void printArray(int[] a) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println("]");
	}
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br= new BufferedReader(new InputStreamReader(System.in));
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
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
