package jenkim49.cart;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jenkim49.product.ProductDao;


public class CartServiceImplMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----------Spring Container 초기화시작-----------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:jenkim49/cart/application-config.xml");
		System.out.println("----------Spring Container 초기화끝-----------");
		CartService cartService=(CartService)applicationContext.getBean("cartService");
		//System.out.println(cartDao.cart_insert(new Cart(18, 2,234000,"jenkim49",38, new java.sql.Date(System.currentTimeMillis()))));		
		//System.out.println(cartDao.cart_updateQty(new Cart(5, 150000, new java.sql.Date(System.currentTimeMillis()), 4)));
		//System.out.println(cartDao.cart_deleteAll("dmsql1"));
		//System.out.println(cartDao.cart_deleteOne(18));
		System.out.println(cartService.cart_viewById("jenkim49"));
		//System.out.println(cartDao.cart_viewByCartNo(1));
	}

}
