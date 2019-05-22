package jenkim49.brand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class brandservicetest{

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		
		BrandService brandService=(BrandService)applicationContext.getBean("brandService");
		
		List<Brand> brandList=brandService.brand_readAll();
		for (Brand brand : brandList) {
			System.out.println(brand.br_name);
		}

	}

}
