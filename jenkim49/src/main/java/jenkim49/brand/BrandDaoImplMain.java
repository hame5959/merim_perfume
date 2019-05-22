package jenkim49.brand;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BrandDaoImplMain {

	public static void main(String[] args) throws Exception {
	

		
		
		System.out.println("----------Spring Container 초기화시작-----------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
			System.out.println("----------Spring Container 초기화끝-----------");
			
			BrandDao brandDao=(BrandDao)applicationContext.getBean("brandDao");
			System.out.println(brandDao.brand_readOneByNo(1));
			System.out.println(brandDao.brand_readAll());
			
	}

}
