package comm.it99plus.srpring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// to load my bean.xml from any folder on the Classpath
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/it99plus/spring/test/beans/beans.xml");

		Person person = (Person) context.getBean("person");
		person.setTaxId(666);
		System.out.println(person);
		
		Address address2 = (Address) context.getBean("address2");
		System.out.println("App -----> " + address2);

		((ClassPathXmlApplicationContext) context).close();
	}

}
