package uvu.cs.cs3250.inclass.demo;

public class Person {

	private Integer age;
	private String lastName;
	private String firstName;
	
	
	public Person(String lastName, String firstName, Integer age) {
		super();
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
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
}
