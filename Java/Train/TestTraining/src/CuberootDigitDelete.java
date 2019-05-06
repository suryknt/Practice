import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CuberootDigitDelete {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int c=(int)Math.cbrt(n);
		while(c-->0) {
			if(isDigitSubset(n, c*c*c))break;
			if(isSubstring(String.valueOf(n),String.valueOf(c*c*c)))break;
		}
		
		System.out.println(c*c*c);
//		System.out.println(getMaxcbrt(n));
		sc.close();
	}
	private static boolean isSubstring(String m, String test) {
		return m.contains(test);
	}
//	private static String getMaxcbrt(int n) {
//		String str=String.valueOf(n);
//		
//		double s=Math.pow(2, str.length());
//		for(int i=0;i<s;i++) {
//			Set<Integer> set=new HashSet<Integer>();
//			int t=i;
//			int count=0;
//			while(t !=0) {
//				
//				if((t&1)==1) {
//					set.add(arr[count]);	
//				}
//				count++;
//				t=t>>1;
//			}
//			System.out.println(set.toString());
//		}
//		return "NOT POSSIBLE";
//		
//	}
	private static boolean isPerfectCube(int i) {
		System.out.println("cube check:: "+i);
		double c=Math.cbrt(i);	
		c=c-(int)c;
		return c==0;
	}
	private static boolean isDigitSubset(int n, int test) {
		Map<Integer,Integer> testmap=new HashMap<Integer,Integer>();
		Map<Integer,Integer> mainmap=new HashMap<Integer,Integer>();
		while(test !=0) {
			if(testmap.containsKey(test%10))testmap.put(test%10, testmap.get(test%10)+1);
			else testmap.put(test%10, 1);
			test/=10;
		}
		while(n !=0) {
			if(mainmap.containsKey(n%10))mainmap.put(n%10,mainmap.get(n%10)+1);
			else mainmap.put(n%10, 1);
			n/=10;
		}
		mainmap.forEach((k,v)->{
			if(testmap.containsKey(k)) {
				if(testmap.get(k)-v!=0)testmap.put(k, testmap.get(k)-v);
				else testmap.remove(k);
			}
		});
		return testmap.isEmpty();
	}
}
