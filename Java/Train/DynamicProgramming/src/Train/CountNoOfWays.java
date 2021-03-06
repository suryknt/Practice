package Train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CountNoOfWays {
	private static int[][] map=new int[10001][101];
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        Arrays.fill(map[1], 1);
        
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] in=br.readLine().split(" ");
            long N = Long.parseLong(in[0]);
            long K = Long.parseLong(in[1]);

            long out_ = solve(K, N);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    
	}
	static long solveIt(long K, long N){
		if(K>N)K=N;
		int mod=1000000007;
		long res=0L;
		if(map[(int)N][(int)K] !=0) return map[(int)N][(int)K];
		else {
			
			for(int i=1;i<N;i++) {
				res+=solveIt(K,N-i);
				res%=mod;
			}
			if(N<=K) res++;
			map[(int)N][(int)K]=(int)res;
		}
		return res;
		
	}
	static long solve(long K, long N){
        // write code here
		if(K>N)K=N;
		if(map[(int)N][(int)K] !=0) return map[(int)N][(int)K];
		
        int mod=1000000007;
        long[] dict=new long[(int)N+1];
        dict[0]=0;
        dict[1]=1;
        long res=0L;
        for(int i=2;i<N+1;i++) {
        	if(map[i][(int)K] ==0) {
        		if(i>K) {
            		for(int j=1;j<=K;j++) {
            			dict[i]+=dict[i-j];
            			dict[i]%=mod;
            		}
            	}
            	else {
            		for(int j=1;j<i;j++) {
            			dict[i]+=dict[i-j];
            			dict[i]%=mod;
            		}
            		dict[i]++;
            	}
        		map[i][(int)K]=(int) dict[i];
        	}
        	else dict[i]=map[i][(int)K];
        }
        printArr(dict);
        return dict[(int)N];
        
    }
//	static long solve(long K, long N){
//        // write code here
//		if(K>N)K=N;
//		if(map[(int)N][(int)K] !=0) return map[(int)N][(int)K];
//		
//        int mod=1000000007;
//        long[] dict=new long[(int)N+1];
//        dict[0]=0;
//        dict[1]=1;
//        long res=0L;
//        for(int i=2;i<N+1;i++) {
//        	if(map[i][(int)K] !=0) {
//        		if(i>K) {
//            		for(int j=1;j<=K;j++) {
//            			dict[i]+=dict[i-j];
//            			dict[i]%=mod;
//            		}
//            	}
//            	else {
//            		for(int j=1;j<i;j++) {
//            			dict[i]+=dict[i-j];
//            			dict[i]%=mod;
//            		}
//            		dict[i]++;
//            	}
//        		map[i][(int)K]=(int) dict[i];
//        	}
//        }
//        printArr(dict);
//        return dict[(int)N];
//        
//    }
	static void printArr(long[] arr) {
		System.out.println("[ ");
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(" "+arr[i]);
		}
		System.out.println("]");
	}
}
