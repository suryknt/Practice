package Train;

import java.util.Scanner;

public class MaximizeStock {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[] price =new int[n];
			for(int i=0;i<n;i++)price[i]=sc.nextInt();
			long profit=0;
			int best=n-1;
			for(int i=n-2;i>=0;i--) {
				int dayProfit=price[best]-price[i];
				if(dayProfit>0) {
					profit+=dayProfit;
				}else {
					best=i;
				}
				
			}
			System.out.println(profit);
		}
		sc.close();
	}
}
