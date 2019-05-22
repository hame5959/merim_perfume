package jenkim49.chat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ChatServiceImplMain {

	public static void main(String[] args) {
		
		System.out.println("------------ Spring Container 초기화시작 -------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");

		System.out.println("------------ Spring Container 초기화 끝  -------------");
		

	}

}
