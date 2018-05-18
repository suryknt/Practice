package Train;

import java.util.Scanner;

public class MaxSumSub2dArray {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int globalMax=Integer.MIN_VALUE/2; //should be minimum possible value of element of the array
			int maxSubArray[][]=new int[r][c];
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					maxSubArray[i][j]=sc.nextInt();
					System.out.print(maxSubArray[i][j]+"  ");
					if(j>=1)maxSubArray[i][j]=Math.max(maxSubArray[i][j], maxSubArray[i][j]+maxSubArray[i][j-1]);
					if(i>=1) maxSubArray[i][j]=Math.max(maxSubArray[i][j], maxSubArray[i][j]+maxSubArray[i-1][j]);
					globalMax=Math.max(globalMax, maxSubArray[i][j]);
					System.out.println(globalMax+"       "+maxSubArray[i][j]);
				}
			}
			System.out.println(globalMax);
		}
	}
}
