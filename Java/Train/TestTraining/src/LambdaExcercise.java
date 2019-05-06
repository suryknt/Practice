import java.util.Arrays;
import java.util.List;

public class LambdaExcercise {
	public static void main(String[] args) {
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",68),
				new Person("Lewis","Carol",42),
				new Person("Thomas","Carlyle",53),
				new Person("Charlette","Brante",45),
				new Person("Mathew","Arnold",39)
				);
		
		LambdaExcercise le=new LambdaExcercise();
		le.printList(people);
		System.out.println(le.sort(people));
		System.out.println("PrintWithC:::");
		le.printListWithC(people);
		
		
	}
	public List<Person> sort(List<Person> people ){
		people.sort(( p1, p2)->p1.getLastName().compareTo(p2.getLastName()));
		return people;
	}
	public void printList(List<Person> people) {
		people.forEach(System.out::println);
	}
	public void printListWithC(List<Person> people) {
		people.forEach(p->{
			if(p.getLastName().startsWith("C")) 
				System.out.println(p); 
		});
	}
	
	
}
