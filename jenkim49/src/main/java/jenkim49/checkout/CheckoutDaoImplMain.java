package jenkim49.checkout;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CheckoutDaoImplMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----------Spring Container 초기화시작-----------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:jenkim49/checkout/application-config.xml");
		System.out.println("----------Spring Container 초기화끝-----------");
		CheckoutDao checkoutDao=(CheckoutDao)applicationContext.getBean("checkoutDao");
		//System.out.println(checkoutDao.checkout_readAll());
		//System.out.println(checkoutDao.checkout_readOneById("jenkim49"));
		//System.out.println(checkoutDao.checkout_readOneByNo(1));
		//System.out.println(checkoutDao.checkout_insert(new Checkout(-999, 1, 120000, "jenkim49", 13, new java.sql.Date(System.currentTimeMillis()), "credit", "Seoul, South Korea")));
		//System.out.println(checkoutDao.checkout_update(new Checkout(8, 1, 120000, "jenkim49", 13, new java.sql.Date(System.currentTimeMillis()), "credit", "Seoul, South Korea")));
		System.out.println(checkoutDao.checkout_delete("cc"));
	}

}
