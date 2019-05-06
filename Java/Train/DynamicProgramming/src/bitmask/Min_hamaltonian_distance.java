package bitmask;

import java.util.Scanner;

public class Min_hamaltonian_distance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] distance=new int[n][n];
		for(int i=0;i<n;i++)for(int j=0;j<n;j++)distance[i][j]=i==j?0:Integer.MAX_VALUE;
		
		while(m-->0) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			distance[x-1][y-1]=z;
			distance[y-1][x-1]=z;
		}
		int size=(int) Math.pow(2, n);
		int[] dp=new int[size];
		
		System.out.println("n:: "+n+" size:: "+size);
		for(int i=0;i<size;i++) {
			if(countSetBits(i)>1)dp[i]=Integer.MAX_VALUE;
			else dp[i]=0;
		}
		
		
		for(int i=1;i<size;i++) {
			for(int j=0;j<n;j++) {
				int localDistance=Integer.MAX_VALUE;
				if((i&(1<<j))!=0) {
					int immediateDistance=Integer.MAX_VALUE;
					for(int k=0;k<n;k++) {
						if(j!=k && (i&(1<<k))!=0)immediateDistance=Math.min(immediateDistance, distance[j][k]);
					}
					System.out.println("immediateDistance:: "+immediateDistance);
					System.out.println("i:: "+i+" (i&~(1<<j)):: "+(i&~(1<<j)));
					localDistance=dp[(i&~(1<<j))]+immediateDistance;
					if(localDistance<0)localDistance=Integer.MAX_VALUE;
					System.out.println("i:: "+i+" j:: "+j+" localDistance::: "+localDistance+" dp[i]:: "+dp[i]);
					dp[i]=Math.min(dp[i], localDistance);
					System.out.println("i:: "+i+" dp[i]:: "+dp[i]);
				}
				
			}
			
		}
		printArr(dp);
		System.out.println(dp[size-1]);
	}
	static void printArr(int[] dp) {
		System.out.print("[ ");
		for(int i=0;i<dp.length;i++) {
			
			System.out.print(" "+dp[i]);
		}
		System.out.println("]");
	}
	private static int countSetBits(int i) {
		int res=0;
		while(i !=0) {
			if((i&1)==1)res++;
			i>>=1;
		}
		return res;
	}
}
