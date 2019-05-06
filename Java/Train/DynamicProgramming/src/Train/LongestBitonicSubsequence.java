package Train;

import java.util.Scanner;

public class LongestBitonicSubsequence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[] a=new int[n];
			int[] lis=new int[n];
			int[] lds=new int[n];
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
				if(i==0) {
					lis[i]=1;
				}else
				for(int j=0;j<i;j++) {
					lis[i]=Math.max(lis[i], a[i]>a[j]?1+lis[j]:1);
				}
			}
			int maxBitonicLength=0;
			for(int i=n-1;i>=0;i--) {
				if(i==n-1)lds[i]=1;
				else for(int j=n-1;j>i;j--) {
					lds[i]=Math.max(lds[i], a[i]>a[j]?1+lds[j]:1);
				}
				maxBitonicLength=Math.max(maxBitonicLength, lis[i]+lds[i]-1);
				System.out.println("i::: "+i+" lis[i]:: "+lis[i]+"  lds[i]:: "+lds[i]+" maxBitonicLength::: "+maxBitonicLength);
			}
			System.out.println(maxBitonicLength);
		}
	}
}
