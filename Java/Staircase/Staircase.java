import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int p=1;
		while(n-->0){
			for(int i=n;i>0;i--)
				System.out.print(" ");
			for(int i=0;i<p;i++)
			System.out.print("#");
			System.out.println();
			p++;
		}
		
	}
}
