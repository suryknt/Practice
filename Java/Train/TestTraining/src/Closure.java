
public class Closure {
	public static void main(String[] args) {
		int[] arr= {9,3,5,7,4,8};
		int b=2;
		for(int i:arr) proceed(i,(k)->System.out.println(i+b));
		
	}
	
	public static void proceed(int i,process p) {
		p.doProcess(i);
	}
}

interface process{
	void doProcess(int i);
}
