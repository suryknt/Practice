import java.util.function.BiConsumer;

public class WrapperLambda {
	public static void main(String[] args) {
		int [] arr= {2,4,6,8,9};
		int key=2;
		process(arr,key,(v,k)->System.out.println(v/k));
		process(arr,key,wrapperLambda((v,k)->System.out.println(v+k)));
	}

	private static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer) {
		for(int a:arr) consumer.accept(a, key);
		
	}
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> con){
		return (v,k)->{
			System.out.println("Exuting from lambda wrapper::");
			con.accept(v, k);
		};
	}
}
