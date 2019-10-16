package uvu.cs.cs3250.inclass.demo;

import java.util.Optional;

public class Person {

	private Integer age;
	private String lastName;
	private String firstName;
	private Optional<Address> address;
	
	
	public Person(String lastName, String firstName, Integer age) {
		super();
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = Optional.empty();
//		Address addr = new Address();
//		this.address = Optional.of(addr);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return this.address.orElseGet(()->{
			Address newAddress = new Address();
			this.address = Optional.ofNullable(newAddress);
			return newAddress;
		});
	}
	
	public Person setAddress(Address address) {
		this.address = Optional.ofNullable(address);
		return this;
	}
}
