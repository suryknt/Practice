package Train;

import java.util.Scanner;

public class BinomialCoefficient {
	static long[][] bincoff=new long[1001][801];
	static boolean[][] status=new boolean[1001][801];
	public static void main(String[] args) {
	    
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int mod=1000000007;
		while(t-->0) {
			int n=sc.nextInt();
			int r=sc.nextInt();
			
// 			
			long binCoeff=getBinomCoeffByDP(n,r,mod);
			System.out.println(binCoeff);
		}
		
	
	}
	private static long getBinomCoeffByDP(int n, int r, int mod) {
//		System.out.println("n::: "+n+"  r:::: "+r+"  status[n][r]:::"+status[n][r]);
		if(status[n][r])return bincoff[n][r];
		if(r>n) return 0;
		long ret=1;
		if(r!=0 && r!=n)ret=(getBinomCoeffByDP(n-1, r-1, mod)%mod + getBinomCoeffByDP(n-1, r, mod)%mod)%mod;
		bincoff[n][r]=ret;
		status[n][r]=true;
//		System.out.println(ret);
		return ret;
	}
	
	private static long getBinomialCoeff(int n,int r, int mod) {
		// gets TLE
		long[] factorial=new long[n+1];
		factorial[0]=1;
		for(int i=1;i<=n;i++)factorial[i]=(factorial[i-1]*i)%mod;
		return n>r?(factorial[n]*modInverse((factorial[r]*factorial[n-r])%mod, mod))%mod:0;
	}
	static int modInverse(long a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
           if ((a * x) % m == 1)
              return x;
        return 1;
    }
}
