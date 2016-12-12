import java.util.Scanner;

public class BonAppetit {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] p=new int[n];
		int sum=0;
		for(int i=0;i<n;i++){
			if(i !=k)
			sum +=sc.nextInt();
			else
				sc.nextInt();
		}
		
		int c=sc.nextInt();
		
		n=c-sum/2;
		if(n==0){
			System.out.println("Bon Appetit");
		}
		else
			System.out.println(n);
		
	sc.close();	
		
	}
}
