package comm.it99plus.srpring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// relative to the program working directory
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/it99plus/spring/test/beans/beans.xml");  
		
		Person person =  (Person) context.getBean("person");
		
		person.speak();
		
		((FileSystemXmlApplicationContext)context).close(); 
	}

}
