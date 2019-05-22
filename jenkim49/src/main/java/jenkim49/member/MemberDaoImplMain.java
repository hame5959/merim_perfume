package jenkim49.member;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MemberDaoImplMain {

	public static void main(String[] args) throws Exception {
		System.out.println("------------ Spring Container 초기화시작 -------------");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		MemberDao memberDao = (MemberDao) applicationContext.getBean("memberDao");
		System.out.println("------------ Spring Container 초기화 끝  -------------");
		/*
		 * READ ALL
		 */
		System.out.println("============================== readAll ===================================");
		ArrayList<Member> memberList = memberDao.member_readAll();
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}
		
		/*
		 * INSERT
		 */
		//memberDao.member_insert(new Member(-999, "testId1", "12341", "test이름1", "test전화번호1", "test이메일1", "test주소1"));
		
		
		
		/*
		 * READ ONE BY ID
		 */
		System.out.println("============================== readOnebyId  ================================");
		System.out.println(memberDao.member_readOneById("jenkim49"));
		
		/*
		 * READ ONE BY NO
		 */
		System.out.println("============================== readOnebyNo  =================================");
		System.out.println(memberDao.member_readOneByNo(3));
		
		/*
		 * UPDATE
		 * "UPDATE member SET m_id=?, m_password=?, m_name=?, 
		 *  m_contact=?, m_email=?, m_address=? WHERE m_id=?";
	
		 */
		
		System.out.println(memberDao.member_update(new Member(-999,"testId", "1111", "test이름수정1", "test전화수정1", "test메일수정1", "test주소수정1")));
		
		/*
		 * DELETE
		 */
		//memberDao.member_delete("testId");
		//memberDao.member_delete("testId1");
		
		/*
		 * READ ALL
		 */
		memberList = null;
		System.out.println("============================== readAll ===================================");
		memberList = memberDao.member_readAll();
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}

	}

}
