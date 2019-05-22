package jenkim49.review;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ReviewDaoImplMain {
	
	public static void main(String[] args) throws Exception{
		System.out.println("---------Spring Container 초기화시작");
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		ReviewDao reviewDao = (ReviewDao) applicationContext.getBean("reviewDao");
		System.out.println("------------ Spring Container 초기화 끝  -------------");
		
		
		/*
		 * Read All
		 */
		
		
		
		
		  System.out.
		 println("============================== readAll ==================================="
		  ); ArrayList<Review> rvList = reviewDao.readAll(); for (int i = 0; i
		  <rvList.size(); i++) { System.out.println(rvList.get(i).toString()); }
		 
		 
		 
		 //System.out.println("=============");
			 //Review read =  reviewDao.rv_readOne(4);
			 //System.out.println(read.toString());
		/* Date nowDate= new Date(); */
			
		
		/*
		 * Review newreview = new Review(-999,3, 2, "4dnjf", "user1", 0,
		 * "review인서트",null, -999, 1,1); boolean ok= reviewDao.reviewInsert(newreview);
		 * System.out.println(ok);
		 */
		 
			 
		//reviewDao.ReviewDelete(15);
		
		//Review newreview = new Review(2,5,1, "[RE]추가용", "admin", 0, "review답글답글",null, 0, 2, 2);
		 //int ok=reviewDao.reviewReply(newreview);
		 //System.out.println(ok);
			  
		 //2	5	1	첫향수에요	user1	1	입문으로 조금 비싸다고 생각하지만 역시 끌로에입니다. 	2019/04/18	2	1	1	  
			 
			 //Qna [Q_no=20, P_no=2, Q_title=추가용, M_id=user1, Q_count=0, 
			 //Q_content=질문게시판인서트, Q_date=2019-04-17, Q_groupNo=20, Q_step=1, Q_depth=1]
			
			 
			 //"INSERT INTO QNA VALUES(QNA_no_seq.nextval,?,?,?,?,?,SYSDATE,?,?,?)";
			 
			 //Qna newQna = new Qna(20, 2, "[RE]추가용", "admin", 0, "게시판답글답글",null, 0, 1, 1);
			 //int ok=qnaDao.qnaReplay(newQna);
			// System.out.println(ok);
			 
		/*
		 * System.out.println("=====readOnepNo========"); ArrayList<Review> rvList =
		 * reviewDao.review_readOnepNo(1); for(int i=0; i<rvList.size(); i++) {
		 * System.out.println(rvList.get(i).toString()); }
		 */
			 
			
			
		}
	}