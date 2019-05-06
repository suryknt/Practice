
public class MethodReference {
	public static void main(String[] args) {
		Thread t1 =new Thread(MethodReference::printMessage);
		Thread t2 =new Thread(()->printMessage());
		Thread t3 =new Thread(()->printMessage());
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void printMessage() {
		System.out.println("This is object saying hello!");
	}
	
}
