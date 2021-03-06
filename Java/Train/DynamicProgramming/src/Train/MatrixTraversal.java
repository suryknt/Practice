package Train;

import java.util.Scanner;

public class MatrixTraversal {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int mod=1000000007;
		while(t-->0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			int k=sc.nextInt();
			int[][] a=new int[n][m];
			while(k-->0) {
				int r=sc.nextInt()-1;
				int c=sc.nextInt()-1;
				a[r][c]=-1;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(a[i][j] !=-1) {
						if(i==0 && j==0)a[i][j]=1;
						else if(i==0)a[i][j]=a[i][j-1];
						else if(j==0)a[i][j]=a[i-1][j];
						else {
							int s=0;
							if(a[i-1][j] != -1)s+=a[i-1][j]%mod;
							if(a[i][j-1] != -1)s+=a[i][j-1]%mod;
							s%=mod;
							a[i][j]=s;
						}
					}
					
//					System.out.println("i:: "+i+" j:: "+j+" a[i][j]:: "+a[i][j]);
				}
			}
			System.out.println(a[n-1][m-1]);
		}
	}
}
