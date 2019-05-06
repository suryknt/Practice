package Train;

import java.util.Scanner;

public class GcdLcm {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int gcd=getGCD(n1,n2);
		int lcm=getLCM(n1,n2);
		System.out.println("GCD:: "+gcd+"  LCM:: "+lcm);
		sc.close();
	}
	
	
	
	private static int getGCD(int n1, int n2) {
		if(n1==0) return n2;
		while(n2>0) {
			int temp=n2;
			n2=n1%n2;
			n1=temp;			
		}
		return n1;
	}
	private static int getLCM(int n1, int n2) {
		int gcd=getGCD(n1,n2);
		return n1*n2/gcd;
	}
			
}
