package Train;

import java.util.Scanner;

public class Max_subsequence_sum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int subseq_sum=0;
			int subarray_sum=Integer.MIN_VALUE;
			int subarray_prev=Integer.MIN_VALUE;
			int subarray_global_sum=Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				int num=sc.nextInt();
				if(i==0)subseq_sum=num;
				
				else if(num>0)subseq_sum+=num;
				subarray_sum=Math.max(subarray_prev+num, num);
				subarray_global_sum=Math.max(subarray_global_sum, subarray_sum);
				subarray_prev=subarray_sum;
			}
			System.out.println(subarray_global_sum+" "+subseq_sum);
		}
	}
}
