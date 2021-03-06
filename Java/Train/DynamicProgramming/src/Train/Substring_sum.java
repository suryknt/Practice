package Train;

import java.io.IOException;
import java.util.Scanner;

public class Substring_sum {

    // Complete the substrings function below.
	    static long substrings(String sn) {
	        char[] a=sn.toCharArray();
	        int n=a.length;
	        long prev=0;
			long result=0;
			int mod=1000000007;
			long mult=1;
			for(int i=n-1;i>=0;i--) {
				int curr=Character.getNumericValue(a[i]);
				long sum=curr*mult+prev;
				prev=sum;
				result+=sum;
				result%=mod;
				mult+=Math.pow(10, n-i);
			}
	        return result;
	    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.));

        String n = scanner.nextLine();

        long result = substrings(n);

        System.out.println(String.valueOf(result));
        

        scanner.close();
    }}
