package jenkim49.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TagDaoImplMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----------Spring Container 초기화시작-----------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:jenkim49/tag/application-config.xml");
			System.out.println("----------Spring Container 초기화끝-----------");
			
			TagDao tagDao=(TagDao)applicationContext.getBean("tagDao");
			System.out.println(tagDao.tag_readOneByNo(1));
			System.out.println(tagDao.tag_readAll());
		
	}

}
