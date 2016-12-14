import java.util.Scanner;

public class BoneTrousle {
	public static void main(String[] args) {
		
		
		
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			long n=sc.nextLong();
			long k=sc.nextLong();
			int b=sc.nextInt();	
			
			long min=(1+b)*b/2;
			long max=(2*k-b+1)*b/2;
			long[] Arr=new long[b+1];
			for(int i=1;i<=b;i++)
				Arr[i]=i;
		//	System.out.println("min>>>"+min+"   max>>>>>"+max);
			if(n>=min && n<=max){
				long left=n-min;
				long p=k-b+1;
				int c=b;
				while(left !=0){
					if(left-p<=0){
						Arr[c] += left;
						left =0;
					}
					else{
						left -=p;
						Arr[c] += p;
						c--;
					}
					
				}
				
				for(int i=1;i<=b-1;i++)
					System.out.print(Arr[i]+" ");
				
				System.out.println(Arr[b]);
			}
			else
				System.out.println(-1);
			
		}
	}

}
