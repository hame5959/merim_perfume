package jenkim49.product;

import java.util.List;

public interface ProductService {

	boolean product_insert(Product product) throws Exception;

	boolean product_update(Product updateProduct) throws Exception;

	boolean product_delete(int p_no) throws Exception;

	List<Product> product_readAllMain() throws Exception;

	List<Product> product_readAllAdmin() throws Exception;

	Product product_readOne(int p_no) throws Exception;

	List<Product> product_search(String p_name) throws Exception;

	List<Product> product_survey_match(String m_id, String s_gender, String s_fav1, String s_fav2, String s_fav3,
			String s_age) throws Exception;

	List<Product> product_recommend(String t_name) throws Exception;

	List<Product> product_readAllPopular() throws Exception;

	/********************************************************************************************************************
	 * 1category_all, men, women = product category page
	 */

	int getProductCount() throws Exception;

	int getProductCountMen() throws Exception;

	int getProductCountWomen() throws Exception;

	List<Product> product_readAllCategory(int startR, int endR) throws Exception;

	List<Product> product_readAllCategoryNameAsc(int startR, int endR) throws Exception;

	List<Product> product_readAllCategoryNameDesc(int startR, int endR) throws Exception;

	List<Product> product_readAllCategoryPriceAsc(int startR, int endR) throws Exception;

	List<Product> product_readAllCategoryPriceDesc(int startR, int endR) throws Exception;

	List<Product> product_readAllCategoryPopular(int startR, int endR) throws Exception;

	List<Product> product_readFemaleCategory(int endR, int startR) throws Exception;

	List<Product> product_readFemaleCategoryNameAsc(int endR, int startR) throws Exception;

	List<Product> product_readFemaleCategoryNameDesc(int endR, int startR) throws Exception;

	List<Product> product_readFemaleCategoryPriceAsc(int endR, int startR) throws Exception;

	List<Product> product_readFemaleCategoryPriceDesc(int endR, int startR) throws Exception;

	List<Product> product_readFemaleCategoryPopular(int endR, int startR) throws Exception;

	List<Product> product_readMaleCategory(int endR, int startR) throws Exception;

	List<Product> product_readMaleCategoryNameAsc(int endR, int startR) throws Exception;

	List<Product> product_readMaleCategoryNameDesc(int endR, int startR) throws Exception;

	List<Product> product_readMaleCategoryPriceAsc(int endR, int startR) throws Exception;

	List<Product> product_readMaleCategoryPriceDesc(int endR, int startR) throws Exception;

	List<Product> product_readMaleCategoryPopular(int endR, int startR) throws Exception;

	boolean product_update(Float p_count, int p_no) throws Exception;

}