package comm.it99plus.srpring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// to load my bean.xml from any folder on the Classpath
		ApplicationContext context = new ClassPathXmlApplicationContext("com/it99plus/spring/test/beans/beans.xml");  
		
		
		Person person1 =  (Person) context.getBean("person");
		Person person2 =  (Person) context.getBean("person");
		
		person1.setTaxId(666);
		
		System.out.println(person2);
		System.out.println(person1);
		
		
		((ClassPathXmlApplicationContext)context).close(); 
	}

}
