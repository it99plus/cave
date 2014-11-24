package comm.it99plus.srpring.test;

public class Address {

	private String street;
	private String postcode;

	public Address() {}

	public Address(String street, String postcode) {
		this.street = street;
		this.postcode = postcode;
	}

	public void init() {
		System.out.println("Bean created: " + this);
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", psotcode=" + postcode + "]";
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	

}
