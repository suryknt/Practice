package Train;

import java.util.Scanner;

public class Winthegame {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			double r=sc.nextDouble();
			double g=sc.nextDouble();
			int counter=0;
			double denom=r+g;
			double num=r;
			double bdenom=denom-1;
			double prob=num/denom;
			double m=prob;
			double ldenom=bdenom;
			if(r!=0 && g !=0) {
				while(ldenom-r>0) {
//					System.out.println("prob::: "+prob+" counter::: "+counter+" ldenom:: "+ldenom+" bdenom:: "+bdenom);

					prob+=m*Math.pow(r, 2*(counter+1))/(bdenom*ldenom);
					ldenom=ldenom-2;
					bdenom=bdenom*(bdenom-1)*ldenom;
					counter++;
				}
				if(ldenom-g==2) {
					prob+=Math.pow(r, 2*(counter+1))/(bdenom*denom);
				}
			}
			else prob=1;
			System.out.printf("%.6f",prob);
			System.out.println();	
		}
		sc.close();
	}
}
