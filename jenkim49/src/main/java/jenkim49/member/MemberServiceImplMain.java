package jenkim49.member;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MemberServiceImplMain {

	public static void main(String[] args) throws Exception {
		System.out.println("------------ Spring Container 초기화시작 -------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		MemberService memberService = (MemberService) applicationContext.getBean("memberService");
		System.out.println("------------ Spring Container 초기화 끝  -------------");
		
		/*
		 * READ ONE BY ID
		 */
		System.out.println("============================== readOnebyId  ================================");
		System.out.println(memberService.member_readOneById("jenkim49"));
	
	}

}
