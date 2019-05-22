package jenkim49.board;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jenkim49.member.Member;
import jenkim49.member.MemberDao;

public class BoardDaoImplMain {
	
	public static void main(String[] args) throws Exception{
		System.out.println("---------Spring Container 초기화시작");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		BoardDao boardDao = (BoardDao) applicationContext.getBean("boardDao");
		System.out.println("------------ Spring Container 초기화 끝  -------------");
		
		
		/*
		 * Read All
		 */
		System.out.println("=============");
		ArrayList<Board> boardList = boardDao.readAll();
		for (int i=0; i< boardList.size(); i++) {
			System.out.println("boardList.get(i)");
		}

}
}