import java.util.Arrays;
import java.util.List;

public class Stream {
	public static void main(String[] args) {
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",68),
				new Person("Lewis","Carol",42),
				new Person("Thomas","Carlyle",53),
				new Person("Charlette","Brante",45),
				new Person("Mathew","Arnold",39)
				);
		System.out.println("printall");
		people.stream()
		.forEach(p->System.out.println(p.getFirstName()));
		System.out.println("Filter with C::");
		people.stream()
		.filter(p->p.getLastName().startsWith("C"))
		.forEach(p->System.out.println(p.getFirstName()));
	}
}
