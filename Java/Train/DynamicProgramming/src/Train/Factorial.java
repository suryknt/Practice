package Train;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Factorial {
	public static Map<Integer,Integer> map= new HashMap<Integer,Integer>();
	public static int mod=1000000007;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        map.put(0,1);
        map.put(1,1);
        while(t-->0){
            int n=s.nextInt();
        
            System.out.println(factorial(n));
        }
       s.close();
	}
	public static int factorial(int n){
        if(map.containsKey(n)) return map.get(n);
        else if(map.containsKey(n-1)) {
        	long res=map.get(n-1)*n%mod;
        	return (int)res;
        }
        else {
        	long res=factorial(n-1)*n%mod;
        	map.put(n, (int)res);
        	return (int)res;
        }
    }
}
