import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Students of Delhi Public School love sweets. They prefer eating sweets all the time. To make sure they remain happy their Maths teacher Pramesh decided to get sweets for them. But since they are students of Delhi Public School they are not so easily pleased.

A student would become happy if there at least X sweets in the class and not more than Y sweets because they know too much of sweets could lead to diabetes. The teacher wants to buy the minimum number of candies so that maximum number of students are happy in his class. Help him in finding out these values.

Input:

The first line contains N indicating the number of students in the class. This is followed up by N lines where every line contains two integers X and Y respectively.

Output:

Output two space-separated integers that denote the minimum number of candies and the maximum number of happy students.

Constraints:
Constraints:

1  N  105

1  X  Y  109

 SAMPLE INPUT 
5
3 6
1 6
7 11
2 15
5 8
SAMPLE OUTPUT 
5 4
 * */
public class Sweets_all_around {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int n=fr.nextInt();
		int[] minSweet=new int[n];
		int[] maxSweet=new int[n];
		for(int i=0;i<n;i++) {
			minSweet[i]=fr.nextInt();
			maxSweet[i]=fr.nextInt();
		}
		Arrays.sort(maxSweet);
		Arrays.sort(minSweet);
//		printArray(maxSweet);
		int maxCount=0,count=0;
		int result=Integer.MAX_VALUE;
		int m1=0,m2=0;
		while(m1<n) {
			if(minSweet[m1]<=maxSweet[m2]) {
				count++;
				m1++;
			}
			else if(minSweet[m1]>maxSweet[m2]) {
				count--;
				m2++;
			}
			if(count>maxCount) {
				maxCount=count;
				result=minSweet[m1-1];
			}
		}
		
		System.out.println(result+" "+maxCount);
	}
	public static void printArray(int[] a) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println("]");
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
	}
}
