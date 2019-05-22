package jenkim49.product;

public class ProductSQL {
	public final static String PRODUCT_INSERT = "INSERT INTO PRODUCT VALUES (PRODUCT_NO_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)";
	public final static String PRODUCT_READALLMAIN= "select DISTINCT p_no,p_name,p_price,p_image from product order by p_no DESC";
	public final static String PRODUCT_READALLADMIN= "SELECT * FROM PRODUCT";
	public final static String PRODUCT_READONE = "select * from product where p_no=?";
	public final static String PRODUCT_UPDATE = "UPDATE product SET p_category=?,br_name=?,p_name=?,p_volume=?,p_price=?,p_image=?,p_keyword=?,p_des=?,p_count=?,t_name=? WHERE p_no=?";
	public final static String PRODUCT_UPDATE_COUNT = "UPDATE product SET p_count=? WHERE p_no=?";
	public final static String PRODUCT_DELETE = "delete product where p_no=?";
	public final static String PRODUCT_SEARCH = "SELECT DISTINCT p_no,p_name,p_price,p_image from product where p_name like ?";
	public final static String PRODUCT_SURVEY_MATCH = "SELECT DISTINCT p_no, p_name, p_price, p_image FROM product p\n" + 
			"LEFT OUTER JOIN gender g\n" + 
			"ON p.p_category = g.g_pcategory\n" + 
			"LEFT OUTER JOIN survey s\n" + 
			"ON s.s_gender=g.g_sgender\n" + 
			"WHERE s.m_id=? AND s.s_gender =? AND p.p_keyword LIKE ? AND p.p_keyword LIKE ? AND p.p_keyword LIKE ? AND p.p_keyword LIKE ?";
	public final static String PRODUCT_RECOMMEND = "SELECT DISTINCT p_no,p_name,p_price,p_image FROM product WHERE t_name=? ORDER BY p_count DESC";
	public final static String PRODUCT_MOSTPOPULAR = "SELECT DISTINCT p_no, p_name, p_price, p_image FROM product ORDER BY p_count DESC";
	 
}
