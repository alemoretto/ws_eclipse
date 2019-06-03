package it.prova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
 
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
		
		obj.setName("pippo");
		obj.printHello();
		
		
		
		
		
		
		obj = null;
		obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
		
		
		
	}

}
