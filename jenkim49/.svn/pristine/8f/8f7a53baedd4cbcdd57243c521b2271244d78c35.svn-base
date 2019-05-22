package jenkim49.chat;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatDaoImplMain {

	public static void main(String[] args) throws Exception {

		System.out.println("------------ Spring Container 초기화시작 -------------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		ChatDao chatDao = (ChatDao) applicationContext.getBean("chatDao");

	
		  System.out.println("====== CHAT_LIST_SELECT_BY_ID ======================");
		  
		  
		
		 ArrayList<ChatVO> chatList = chatDao.Chat_getChatListById("user1"); 
		 for (int i = 0; i < chatList.size(); i++) {
		 System.out.println(chatList.get(i).toString()); }
		 
		
		
		  System.out.println("====== Chat_sumit ======================");
		 // ChatVO newchat = new ChatVO(-999, "하이루!",null, "user1", "admin");
		  //chatDao.Chat_sumit(newchat);
	
		//memberDao.member_insert(new Member(-999, "testId1", "12341", "test이름1", "test전화번호1", "test이메일1", "test주소1"));
			
			
		
		/*
		 * System.out.println("====== CHAT_LIST_SELECT_BY_ID ======================");
		 * 
		 * 
		 * ArrayList<ChatVO> chatList2 = chatDao.Chat_getChatListById("user1"); for (int
		 * i = 0; i < chatList2.size(); i++) {
		 * System.out.println(chatList2.get(i).toString()); }
		 */

	}

}
