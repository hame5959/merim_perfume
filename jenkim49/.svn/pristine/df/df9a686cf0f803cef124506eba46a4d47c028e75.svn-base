package jenkim49.qna;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class QnaServiceImplMain {

	public static void main(String[] args) throws Exception {
		
		
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		
		QnaService qnaService=(QnaService)applicationContext.getBean("qnaService");
		List<Qna> qnalist = qnaService.readAll();
		for(Qna qna : qnalist) {
			System.out.println(qna.toString());
		}

	/* 	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
			
			BrandService brandService=(BrandService)applicationContext.getBean("brandService");
			
			List<Brand> brandList=brandService.brand_readAll();
			for (Brand brand : brandList) {
				System.out.println(brand.br_name);*/
	}

}
