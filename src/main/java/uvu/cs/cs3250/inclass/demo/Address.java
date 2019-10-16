package uvu.cs.cs3250.inclass.demo;

public class Address {
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zip;
	
	public String getLine1() {
		return line1;
	}
	public Address setLine1(String line1) {
		this.line1 = line1;
		return this;
	}
	public String getLine2() {
		return line2;
	}
	public Address setLine2(String line2) {
		this.line2 = line2;
		return this;
	}
	public String getCity() {
		return city;
	}
	public Address setCity(String city) {
		this.city = city;
		return this;
	}
	public String getState() {
		return state;
	}
	public Address setState(String state) {
		this.state = state;
		return this;
	}
	public String getZip() {
		return zip;
	}
	public Address setZip(String zip) {
		this.zip = zip;
		return this;
	}
	
	@Override
	public String toString( ) {
		return line1 + "\n" + line2 + "\n"+city+", "+state+" "+zip;
	}
}
