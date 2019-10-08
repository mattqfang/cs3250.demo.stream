package uvu.cs.cs3250.inclass.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		persons.add(new Person("fang","matt", 21));
		persons.add(new Person("johnson","mark", 82));
		persons.add(new Person("doe","john", 125));
		
		List<Person> results = persons.stream()
			.filter(p -> p.getFirstName().startsWith("m"))
			//.map(Person::getLastName)n not working
			.sorted(Comparator.comparing(Person::getLastName))
			.collect(Collectors.toList());
		
		persons.stream()
			.sorted(Comparator.comparing(Person::getAge))
			.forEach(p -> System.out.println(p.getFirstName()+" "+p.getLastName()));
		
		List<Person> anotherResults = persons.parallelStream()
			.filter(p -> p.getLastName().equalsIgnoreCase("fang") 
					&& p.getFirstName().equalsIgnoreCase("matt"))
			.collect(Collectors.toList());
		
		System.out.println("Matt Fang is "+ anotherResults.get(0).getAge()+ " years old.");

		
		Optional<Person> matt = persons.parallelStream()
			.filter(p -> p.getLastName().equalsIgnoreCase("fang") 
				&& p.getFirstName().equalsIgnoreCase("matt"))
			.findFirst();
		
		if (matt.isPresent()) {
			System.out.println("Matt Fang is "+ matt.get().getAge()+ " years old.");
		}
		
		persons.parallelStream()
		.filter(p -> p.getLastName().equalsIgnoreCase("fang") 
			&& p.getFirstName().equalsIgnoreCase("matt"))
		.findFirst()
		.map(m -> m.getAge())
		.ifPresent(a -> System.out.println("Matt Fang is "+ a + " years old."));
		
//		for(Person person: persons) {
//			if (person.getName().startsWith("m")) {
//				System.out.println(person.getName().substring(0, 1).toUpperCase() 
//						+ person.getName().substring(1).toLowerCase());
//			}
//		}
		
//		persons.stream()
//			.filter(p -> p.getName().startsWith("m"))
//			.map(p -> p.getName())
//			.map(n -> n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase())
//			.sorted()
//			.forEach(System.out::println);
	}

}
