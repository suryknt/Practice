import java.util.Scanner;

public class SherlockAndSquares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int a= sc.nextInt();
			int b=sc.nextInt();
//			System.out.println(Math.floor(Math.sqrt(b)));
//			System.out.println(Math.ceil(Math.sqrt(a)));
			System.out.println((int)(Math.floor(Math.sqrt(b))-Math.ceil(Math.sqrt(a)))+1);
		}
		sc.close();
	}
}
