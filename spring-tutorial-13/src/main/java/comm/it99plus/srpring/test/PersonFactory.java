package comm.it99plus.srpring.test;

public class PersonFactory {

	public Person createPerson(int id, String name) {
		System.out.println("Using factory to create a Person.");
		return new Person(id, name);
		
	}
}
