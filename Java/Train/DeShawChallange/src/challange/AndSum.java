package challange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AndSum {
	static int mod=1000000007;
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int t=fr.nextInt();
		
		while(t-->0) {
			int n=fr.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++) {
				a[i]=fr.nextInt();
			}
//			long sum=getAndSum(a,n);
			long sum=getAndSumWithBitwise(a, n);
			System.out.println(sum);
		}
	}
	
	/*
	 * for each bit position finding its contribution in the final sum
	 * for ith bit find no. of elements in array that have its ith bit set. there will be
	 * let that no. be k. the each subset of the set of these k items will contribute 1
	 * so total sum will be 2^k-1. and the total contribution of this ith sum will be
	 * 2^i*(2^k -1). find for all i and sum it up. that will be the result
	 * */
	
	public static long getAndSumWithBitwise(int[] a,int n) {
		long sum=0L;
		int max=100001;
		long[] pow2=new long[max];
		pow2[0]=1;
		for(int i=1;i<max;i++) {
			pow2[i]=((pow2[i-1]%mod)<<1)%mod;
//			System.out.println("i:: "+i+" pow2:: "+pow2[i]);
		}
		for(int i=1;i>0; i<<=1) {
			int setBitCount=0;
			for(int j=0;j<n;j++) {
//				System.out.println("j:: "+j+" a[j]:: "+a[j]+" a[j]&i:: "+(a[j]&i));
				if((a[j] & i)!=0)setBitCount++;
			}
//			System.out.println("i:: "+i+" setBitCount:: "+setBitCount+" pow2[setBitCount]:: "+pow2[setBitCount]);
			long subsetSum=(pow2[setBitCount])-1;
//			subSetSum-=1;
			sum += i*subsetSum;
			sum%=mod;
		}
		return sum;
	}
	
	//gets TLE
	//simply finding all subsets of array and adnding each element and returning total sum
	public static long getAndSum(int[] a,int n) {
		
		long sum=0L;
		for(int i=1;i<Math.pow(2, n);i++) {
			int and=Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if((i & 1<<j)>0) {
					and &=a[j];
					System.out.println("j::: "+j+" and:: "+and+" a[j]:: "+a[j]);
				}
			}
			sum+=and%mod;
		}
		return sum;
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
