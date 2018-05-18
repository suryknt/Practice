package concept;

import java.util.Scanner;

public class SumOfAndPairs {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int maxArrayLength=31;//for this problem geeksforgeeks
			int[] nc2=new int[maxArrayLength];
			nc2[0]=0;
			nc2[1]=0;
			nc2[2]=1;
			for(int i=3;i<maxArrayLength;i++) {
				nc2[i]=nc2[i-1]+i-1;
//				System.out.println(nc2[i]);
			}
			long sum=0L;
			for(int i=1; i<=(Math.log(100)/Math.log(2))+2;i<<=1) {
				int setBitCount=0;
				for(int j=0;j<n;j++) {
					if((a[j] &i) !=0)setBitCount++;
				}
//				System.out.println("i:: "+i+" setBitCount:: "+setBitCount+" nc2[setBitCount]::: "+nc2[setBitCount]);
				sum+=i*nc2[setBitCount];
			}
			System.out.println(sum);
		}
	}
}
