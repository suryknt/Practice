package Train;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BoxStackingProblem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0) {
			int n=sc.nextInt();
			Box[] boxList=new Box[3*n];
			for(int i=0;i<3*n;i=i+3) {
				int l=sc.nextInt();
				int h=sc.nextInt();
				int b=sc.nextInt();
				boxList[i]=new Box(l, b, h);
				boxList[i+1]=new Box(b,h,l);
				boxList[i+2]=new Box(h, l, b);
			}
			Arrays.sort(boxList,(a,b)->b.getA()-a.getA());
			printArr(boxList);
			int[] dp=new int[3*n];
			int max=0;
			for(int i=0;i<3*n;i++) {
				dp[i]=boxList[i].getH();
				for(int j=0;j<i;j++) {
					if((boxList[i].getB()<boxList[j].getB() && boxList[i].getL()<boxList[j].getL())
						|| (boxList[i].getL()<boxList[j].getB() && boxList[i].getB()<boxList[j].getL())	) {
						dp[i]=Math.max(dp[i], boxList[i].getH()+dp[j]);
					}
				}
				System.out.println("i:: "+i+" dp:: "+dp[i]);
				max=Math.max(max, dp[i]);
			}
			
			System.out.println(max);
		}
		
	}
	static void printArr(Box[] arr) {
		System.out.print("[ ");
		for(int i=0;i<arr.length;i++) {
			
			System.out.print(" "+arr[i]);
		}
		System.out.println("]");
	}
	static class Box {
		int l;
		int b;
		int h;
		int a;
		
		public Box(int l, int b, int h) {
			super();
			this.l = l;
			this.b = b;
			this.h = h;
			this.a=l*b;
		}
		public int getL() {
			return l;
		}
		public void setL(int l) {
			this.l = l;
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		public int getH() {
			return h;
		}
		public void setH(int h) {
			this.h = h;
		}
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[ h:: "+this.h+" l:: "+l+" b:: "+b+" a:: "+a+" ]";
		}
		
		
	}
}
