package uvu.cs.cs3250.inclass.demo;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {
//		List<String> names = new ArrayList<>();
//		names.add("matt");
//		names.add("john");
//		names.add("mark");
//		
//		for(String name: names) {
//			if (name.startsWith("m")) {
//				System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
//			}
//		}
//		
//		for(int n=0; n<names.size(); n++) {
//			System.out.println(names.get(n));
//		}
		
//		names.stream()
//			.filter(n -> n.startsWith("m"))
//			.map(n -> n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase())
//			.forEach(System.out::println);
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("matt", 21));
		persons.add(new Person("mark", 82));
		persons.add(new Person("john", 125));
		
		for(Person person: persons) {
			if (person.getName().startsWith("m")) {
				System.out.println(person.getName().substring(0, 1).toUpperCase() 
						+ person.getName().substring(1).toLowerCase());
			}
		}
		
		persons.stream()
			.filter(p -> p.getName().startsWith("m"))
			.map(p -> p.getName())
			.map(n -> n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase())
			.forEach(System.out::println);
	}

}
