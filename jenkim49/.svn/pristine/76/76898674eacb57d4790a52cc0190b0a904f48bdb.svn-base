package jenkim49.qna;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QnaDaoImplMain {

	public static void main(String[] args) throws Exception {
		System.out.println("---------Spring Container 초기화시작");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		QnaDao qnaDao = (QnaDao) applicationContext.getBean("qnaDao");
		System.out.println("------------ Spring Container 초기화 끝  -------------");

		/*
		 * Read All
		 */
		System.out.println("=============");

		// qnaDao.increaseReadCount(28);
		/*
		 * Qna newQna = new Qna(-999, 1, "제품1", "user1", 0, "질문게시판인서트",null, -999, 0,
		 * 0); boolean ok= qnaDao.qnaInsert(newQna); System.out.println(ok);
		 */ 
		 
		  ArrayList<Qna> qnaList = qnaDao.readAll();
		/*
		 * for (int i=0; i< qnaList.size();i++) {
		 * System.out.println(qnaList.get(i).toString()); }
		 */
		  System.out.println("=========readAll==Q_GROUPNO DESC, Q_STEP ASC==");
		  for (int i=0; i< qnaList.size();i++) 
		  { System.out.println(qnaList.get(i).getQ_title()); }
		System.out.println("=========readPno==Q_GROUPNO DESC, Q_STEP ASC==");
		
		List<Qna> qnaListPno =qnaDao.Qna_readOne_Pno(2);
		  for (int i=0; i< qnaListPno.size();i++) 
		  { System.out.println(qnaListPno.get(i)); }
		  
		  System.out.println("=====readone========");
		  Qna read =  qnaDao.qna_readOne(20);
		  System.out.println(read.toString());

		/*
		 * ArrayList<Qna> qnaListp_no = qnaDao.Qna_readOne_Pno(1); for (int i=0;
		 * i<qnaListp_no.size();i++) {
		 * System.out.println(qnaListp_no.get(i).toString()); }
		 */
		// Qna newQna = new Qna(-999, 1, "제품1", "user1", 0, "질문게시판인서트",null, -999, 1,
		// 1);

		// Qna read = qnaDao.qna_readOne(2);
		// System.out.println(read.toString());
		// Date nowDate= new Date();
		/*
		 * Qna newQna = new Qna(-999, 2, "추가용", "user1", 0, "질문게시판인서트",null, -999, 1,
		 * 1); boolean ok= qnaDao.qnaInsert(newQna); System.out.println(ok);
		 */

		// Qna [Q_no=20, P_no=2, Q_title=추가용, M_id=user1, Q_count=0,
		// Q_content=질문게시판인서트, Q_date=2019-04-17, Q_groupNo=20, Q_step=1, Q_depth=1]

		// "INSERT INTO QNA VALUES(QNA_no_seq.nextval,?,?,?,?,?,SYSDATE,?,?,?)";

		// Qna newQna = new Qna(20, 2, "[RE]추가용", "admin", 0, "게시판답글답글",null, 0, 1, 1);
		// int ok=qnaDao.qnaReplay(newQna);
		// System.out.println(ok);

		System.out.println("=============");

	}
}