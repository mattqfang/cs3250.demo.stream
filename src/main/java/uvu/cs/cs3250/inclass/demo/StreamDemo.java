package uvu.cs.cs3250.inclass.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		Address address1 = new Address()
				.setLine1("150 s 300 w")
				.setCity("Orem")
				.setState("UT")
				.setZip("84497");
		
		Address address2 = new Address()
				.setLine1("150 n 300 w")
				.setCity("Orem")
				.setState("UT")
				.setZip("84497");
		
		persons.add(new Person("fang","matt", 21).setAddress(address1));
		persons.add(new Person("johnson","mark", 82).setAddress(address2));
		persons.add(new Person("doe","john", 125));
		
		Address mattAddr = StreamDemo.findAddressByName("matt", "fang", persons);
		
		System.out.println(mattAddr);
		
		Address jeffAddr = StreamDemo.findAddressByName("jeff", "fang", persons);
		
		System.out.println(jeffAddr);
		
		int mattAge = StreamDemo.findAgeByName("matt", "fang", persons);
		
		System.out.println(mattAge);
		
		Integer jeffAge = StreamDemo.findAgeByName("jeff", "fang", persons);
		
		System.out.println(jeffAge);
		
		List<Person> utahPeople = StreamDemo.findPersonsByState("ut", persons);
		
		utahPeople.stream()
			.forEach(System.out::println);
		
		List<Person> nevadaPeople = StreamDemo.findPersonsByState("nv", persons);
		
		nevadaPeople.stream()
			.forEach(System.out::println);
		
	}
	
	public static Address findAddressByName(String firstName, String lastName, List<Person> persons) {
		return persons.stream()
			.filter(p -> p.getFirstName().equalsIgnoreCase(firstName) && 
						 p.getLastName().equalsIgnoreCase(lastName))
			.findFirst()
			.map(p -> p.getAddress())
			.orElse(new Address());
			
	}
	
	public static Integer findAgeByName(String firstName, String lastName, List<Person> persons) {
		return persons.stream()
			.filter(p -> p.getFirstName().equalsIgnoreCase(firstName) && 
						 p.getLastName().equalsIgnoreCase(lastName))
			.findFirst()
			.map(p -> p.getAge())
			.orElseGet(() -> {
				System.out.println("cannot find this person!");
				return null;
			});
	}
	
	public static List<Person> findPersonsByState(String state, List<Person> allPersons) {
		return allPersons.stream()
				.filter(p -> p.getAddress() != null)
				.filter(p -> state.equalsIgnoreCase(p.getAddress().getState()))
				.collect(Collectors.toList());
	}

}
