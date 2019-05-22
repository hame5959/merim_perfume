package jenkim49.product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = new ProductDaoImpl();

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		;
	}

	@Override
	public boolean product_insert(Product product) throws Exception {
		return productDao.product_insert(product);
	}

	@Override
	public boolean product_update(Product updateProduct) throws Exception {
		return productDao.product_update(updateProduct);
	}
	
	@Override
	public boolean product_update(Float p_count, int p_no) throws Exception {
		return productDao.product_update(p_count, p_no);
	}

	@Override
	public boolean product_delete(int p_no) throws Exception {
		return productDao.product_delete(p_no);
	}

	@Override
	public List<Product> product_readAllMain() throws Exception {
		return productDao.product_readAllMain();
	}

	@Override
	public List<Product> product_readAllAdmin() throws Exception {
		return productDao.product_readAllAdmin();
	}

	@Override
	public Product product_readOne(int p_no) throws Exception {
		return productDao.product_readOne(p_no);
	}

	@Override
	public List<Product> product_search(String p_name) throws Exception {
		return productDao.product_search(p_name);
	}

	@Override
	public List<Product> product_survey_match(String m_id, String s_gender, String s_fav1, String s_fav2, String s_fav3,
			String s_age) throws Exception {
		return productDao.product_survey_match(m_id, s_gender, s_fav1, s_fav2, s_fav3, s_age);
	}

	@Override
	public List<Product> product_recommend(String t_name) throws Exception {
		return productDao.product_recommend(t_name);
	}

	@Override
	public List<Product> product_readAllPopular() throws Exception {
		return productDao.product_readAllPopular();
	}

	/********************************************************************************************************************
	 * 1category_all, men, women = product category page
	 */

	@Override
	public int getProductCount() throws Exception {
		return productDao.getProductCount();
	}

	@Override
	public int getProductCountMen() throws Exception {
		return productDao.getProductCountMen();
	}

	@Override
	public int getProductCountWomen() throws Exception {
		return productDao.getProductCountWomen();
	}

	@Override
	public List<Product> product_readAllCategory(int startR, int endR) throws Exception {
		return productDao.product_readAllCategory(startR, endR);
	}

	@Override
	public List<Product> product_readAllCategoryNameAsc(int startR, int endR) throws Exception {
		return productDao.product_readAllCategoryNameAsc(startR, endR);
	}

	@Override
	public List<Product> product_readAllCategoryNameDesc(int startR, int endR) throws Exception {
		return productDao.product_readAllCategoryNameDesc(startR, endR);
	}

	@Override
	public List<Product> product_readAllCategoryPriceAsc(int startR, int endR) throws Exception {
		return productDao.product_readAllCategoryPriceAsc(startR, endR);
	}

	@Override
	public List<Product> product_readAllCategoryPriceDesc(int startR, int endR) throws Exception {
		return productDao.product_readAllCategoryPriceDesc(startR, endR);
	}

	@Override
	public List<Product> product_readAllCategoryPopular(int startR, int endR) throws Exception {
		return productDao.product_readAllCategoryPopular(startR, endR);
	}

	@Override
	public List<Product> product_readFemaleCategory(int endR, int startR) throws Exception {
		return productDao.product_readFemaleCategory(endR, startR);
	}

	@Override
	public List<Product> product_readFemaleCategoryNameAsc(int endR, int startR) throws Exception {
		return productDao.product_readFemaleCategoryNameAsc(endR, startR);
	}

	@Override
	public List<Product> product_readFemaleCategoryNameDesc(int endR, int startR) throws Exception {
		return productDao.product_readFemaleCategoryNameDesc(endR, startR);
	}

	@Override
	public List<Product> product_readFemaleCategoryPriceAsc(int endR, int startR) throws Exception {
		return productDao.product_readFemaleCategoryPriceAsc(endR, startR);
	}

	@Override
	public List<Product> product_readFemaleCategoryPriceDesc(int endR, int startR) throws Exception {
		return productDao.product_readFemaleCategoryPriceDesc(endR, startR);
	}

	@Override
	public List<Product> product_readFemaleCategoryPopular(int endR, int startR) throws Exception {
		return productDao.product_readFemaleCategoryPopular(endR, startR);
	}

	@Override
	public List<Product> product_readMaleCategory(int endR, int startR) throws Exception {
		return productDao.product_readMaleCategory(endR, startR);
	}

	@Override
	public List<Product> product_readMaleCategoryNameAsc(int endR, int startR) throws Exception {
		return productDao.product_readMaleCategoryNameAsc(endR, startR);
	}

	@Override
	public List<Product> product_readMaleCategoryNameDesc(int endR, int startR) throws Exception {
		return productDao.product_readMaleCategoryNameDesc(endR, startR);
	}

	@Override
	public List<Product> product_readMaleCategoryPriceAsc(int endR, int startR) throws Exception {
		return productDao.product_readMaleCategoryPriceAsc(endR, startR);
	}

	@Override
	public List<Product> product_readMaleCategoryPriceDesc(int endR, int startR) throws Exception {
		return productDao.product_readMaleCategoryPriceDesc(endR, startR);
	}

	@Override
	public List<Product> product_readMaleCategoryPopular(int endR, int startR) throws Exception {
		return productDao.product_readMaleCategoryPopular(endR, startR);
	}

}
