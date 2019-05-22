package jenkim49.jumundetail;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JumunDetailDaoImplMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----------Spring Container 초기화시작-----------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:jenkim49/jumundetail/application-config.xml");
		System.out.println("----------Spring Container 초기화끝-----------");
		JumunDetailDao jdDao=(JumunDetailDao)applicationContext.getBean("jumunDetailDao");
		//System.out.println(jdDao.jumundetail_insert(new JumunDetail(-999, 3, 120000, 2, 5)));
		//System.out.println(jdDao.jumundetail_update(new JumunDetail(2, 1, 240000, 2, 1)));
		//System.out.println(jdDao.jumundetail_delete(18));
		//System.out.println(jdDao.jumundetail_readJdNo(2));
		System.out.println("-------------------------------------------");
		//System.out.println(jdDao.jumundetail_readAll());
		System.out.println(jdDao.jumundetail_readJNo(224));

	}

}
