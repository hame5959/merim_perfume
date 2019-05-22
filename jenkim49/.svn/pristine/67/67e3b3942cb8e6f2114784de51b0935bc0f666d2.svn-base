package jenkim49.cart;

public class CartSQL {
	public final static String CART_INSERT = "INSERT INTO cart values(cart_no_seq.nextval,?,?,SYSDATE,?,?)";
	public final static String CART_VIEWBYID = "SELECT * FROM cart c JOIN product p ON c.p_no = p.p_no WHERE m_id=?";
	public final static String CART_UPDATEQTY = "UPDATE cart SET cart_qty=?, cart_price=?, cart_date=sysdate where cart_no=?";
	public final static String CART_DELETEALL = "DELETE FROM cart WHERE m_id=?";
	public final static String CART_DELETEONE = "DELETE FROM cart WHERE cart_no=?";
	public final static String CART_DELETEDATE = "DELETE  FROM cart WHERE ROUND(SYSDATE - cart_date) > 7";
	public final static String CART_VIEWBYCARTNO = "SELECT * FROM cart c JOIN product p ON c.p_no = p.p_no AND cart_no=?";
}
