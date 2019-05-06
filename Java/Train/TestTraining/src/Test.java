import java.lang.invoke.LambdaConversionException;

public class Test {
	
	public void greet() {
		System.out.println("hello world!");
	}
	public void lambdaGreet(Greeting g) {
		g.perform();
	}
	public static void main(String[] args) {
		Test t=new Test();
		t.greet();
		Greeting myLamdaFunction=()->System.out.println("hello Lambda world!");
		t.lambdaGreet(myLamdaFunction);
		Greeting aic=new Greeting() {
			
			@Override
			public void perform() {
				System.out.println("Hello Anonymous inner type world !");
				
			}
		};
		t.lambdaGreet(aic);
			
	}
	
}
interface Greeting {
	public void perform();
}

