import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Shruti loves to play with Array. She would always be busy doing some random operation with her array. Today she got to know about Magic Potion. A Magic Potion is a special power that allows you to remove one element from your array either from the start or the end. After spending some time on Magic Potion she decided to use it on her arrays.

Shruti has an array of size N. She calls an array a Good array if the sum of the array is exactly K. She wants to apply Magic Potion on her array so that she could get a Good array. She wants to find the count of all the Good arrays that could be formed from the given initial array by applying Magic Potion on them any number of times. She is also interested in finding out the minimum Magic Potion required to form a single Good array. Since she is already quite busy she asks you for help.

Input:

The first line contains 2 integers N and K denoting the size of the array and the sum value required for an array to be Good.This is followed by N-space separated integers that denote the array.

Output:

Print two space-separated integers where the first integers denote the count of all possible Good arrays while the second integers indicate minimum Magic Potion required for a Good array.

Constraints:

1  N  105

1  K  1012

0  Ai  109

Note:

A Good Array will always exist.

SAMPLE INPUT 
3 3
1 2 3
SAMPLE OUTPUT 
2 1
 * 
 * 
 * */
public class Magic_potion {
	public static void main(String[] args) {
		FastReader fr=new FastReader();
		int n=fr.nextInt();
		long k=fr.nextLong();
		long[] sArray=new long[n];
		long[] bArray=new long[n];
		long goodArrayCount=0;
		int minOp=n;
		int backIndex=0;
		sArray[0]=fr.nextLong();
		bArray[0]=sArray[0]+k;
		if(sArray[0]==k)goodArrayCount++;
		for (int i=1;i<n;i++) {
			sArray[i]=sArray[i-1]+fr.nextLong();
			bArray[i]=sArray[i]+k;
			if(sArray[i]==k) {
				goodArrayCount++;
				minOp=Math.min(minOp, n-i-1);
			}
			while(bArray[backIndex]<=sArray[i]-k) {
				backIndex++;
			}
			int j=binarySearch(bArray,sArray[i],0,i);
			int f=j;
			while(f>=0 && bArray[j]==sArray[i]) {
				goodArrayCount++;
				minOp=Math.min(minOp, j+n-i);
				j++;
			}
			f=j;
			while(f>=0 && bArray[j]==sArray[i]) {
				goodArrayCount++;
				minOp=Math.min(minOp, j+n-i);
				j--;
			}
//			int j=i;
//			while(j>=0 && bArray[j]>=sArray[i]) {
//				
//				if(bArray[j]==sArray[i]) {
//					goodArrayCount++;
//					minOp=Math.min(minOp, j+n-i);
//				}
//				j--;
//			}
		}
		System.out.println(goodArrayCount+" "+minOp);
//		long[] a = {12,34, 56,78,99,101};
//		System.out.println(binarySearch(a, 34, 0, 5));
		
	}
	
	private static int binarySearch(long[] a,long num, int start, int end) {
		if(start>end)return -1;
		if(start==end) {
			if(a[start]==num)return start;
			else return -1;
		}
		int mid=start+(end-start)/2;
		if(a[mid]==num)return mid;
		else if(a[mid]<num)return binarySearch(a, num, mid+1, end);
		else return binarySearch(a, num, start, mid-1);
		
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public long nextLong() {
			return Long.parseLong(next());
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
