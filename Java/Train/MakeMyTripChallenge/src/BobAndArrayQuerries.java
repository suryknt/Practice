import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 * Bob And Array Queries
Bob has an array A[] of N integers. Initially, all the elements of the array are zero. Bob asks you to perform Q operations on this array.

There are three types of operations that can be performed:

 1 X: Update the value of A[X] to  2 * A[X] + 1.
 2 X: Update the value A[X] to  A[x]/2 , where  is Greatest Integer Function.
 3 X Y: Take all the A[i] such that  X <= i <= Y and convert them into their corresponding binary strings. Now concatenate all the binary strings and find the total no. of '1' in the resulting string.
Note: It is guaranteed that there is at least 1 type-3 query in the every test case. All the array elements will fit into 64 bit integers.

Input Format:
First line consists of two space-separated integers N and Q.
Next, Q lines consist of Q operations of either of the 3 types as described above.

Output Format:
For each type-3 query print the answer that is the no. of '1' in the resulting string.

Constraints:


 

 

Sample Input
5 5
1 1
1 2
1 3
3 1 3
3 2 4
Sample Output
3
2
Explanation
Initially, A=[0,0,0,0,0]

After 1st query, A=[1,0,0,0,0]

After 2nd query, A=[1,1,0,0,0]

After 3rd query, A=[1,1,1,0,0]

For 4th query, no. of '1' in binary representation of A[1]=A[2]=A[3]=1. So, answer=3.

For 5th query, answer is 2.
 * 
 * 
 * 
 * */
public class BobAndArrayQuerries {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int n=fr.nextInt();
		int q=fr.nextInt();
		
		int[] bitcount=new int[n];
		while(q-->0) {
			int type=fr.nextInt();
			if(type==1) {
				int x1=fr.nextInt()-1;
				for(int i=x1;i<n;i++)bitcount[i]++;
				System.out.println("bitcount[x1]::: "+bitcount[x1]);
				
			}
			else if(type==2) {
				int x2=fr.nextInt()-1;
				for(int i=x2;i<n;i++)bitcount[i]--;
//				bitcount[x2]=bitcount[x2]>0?bitcount[x2]-1:0;
				System.out.println("bitcount[x2]::: "+bitcount[x2]);
				
			}
			else {
				int x=fr.nextInt()-1;
				int y=fr.nextInt()-1;
				int count=0;
//				for(int i=x;i<=y;i++) {
////					System.out.println("i:: "+i+" bitcount[i]::: "+bitcount[i]+" count::: "+count);
//					count+=bitcount[i];
//				}
				System.out.println(bitcount[y]-bitcount[x]);
			}
		}
//		System.out.println(countSetBits(10));
	}
	public static int countSetBits(long n) {
		int count=0;
		while(n>0) {
			n &= n-1;
			count++;
		}
		return count;
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() {
			while(st==null || !st.hasMoreElements()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
